package com.ikn.ums.bi.report.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.ums.bi.report.exception.EmptyInputException;
import com.ikn.ums.bi.report.exception.ErrorCodeMessages;
import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.service.MeetingService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	private RestTemplate restTemplate;
	private String meetingMicroserviceMeetingControllerURL = "http://UMS-MEETING-SERVICE/meetings";

	@Override
	public List<Meeting> getMeetingsByOrganizer(String organizer) {
		log.info("getMeetingsByOrganizer() is entered");
		if(organizer == null || organizer == "") {
			log.info("getMeetingsByOrganizer() EmptyInputException: "+ organizer);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_MSG);
		}
		log.info("getMeetingsByOrganizer() is under execution...");
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(this.meetingMicroserviceMeetingControllerURL+"/organized/"+organizer, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>() {
				});
		List<Meeting> organizerMeetingList = response.getBody();
		log.info("getMeetingsByOrganizer() executed successfully ");
		return organizerMeetingList;
	}

	@Override
	public List<Meeting> getMeetingsByDepartment(Long departmentId) {
		log.info("getMeetingsByDepartment() is entered");
		if(departmentId <= 0 || departmentId == null) {
			log.info("getMeetingsByDepartment() EmptyInputException"+ departmentId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_MSG);
		}
		log.info("getMeetingsByDepartment() is under execution...");
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(this.meetingMicroserviceMeetingControllerURL+"/department/"+departmentId, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>() {
				});
		List<Meeting> meetingListOfDepartment = response.getBody();
		log.info("getMeetingsByDepartment() executed successfully ");
		return meetingListOfDepartment;
	}

	@Override
	public List<Meeting> getMeetingsByAttendee(String attendee) {
		log.info("getMeetingsByAttendee() is entered");
		if(attendee == null) {
			log.info("getMeetingsByAttendee() EmptyInputException"+ attendee);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_MSG);
		}
		log.info("getMeetingsByAttendee() is under execution...");
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(this.meetingMicroserviceMeetingControllerURL+"/attended/"+attendee, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>() {
				});
		List<Meeting> attendeeMeetingList = response.getBody();
		log.info("getMeetingsByAttendee() executed successfully ");
		return attendeeMeetingList;
	}

	@Override
	public List<Meeting> getAllMeetings() {
		log.info("getAllMeetings() is entered");
		log.info("getAllMeetings() is under execution...");
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(
	            this.meetingMicroserviceMeetingControllerURL+"/all", 
	            HttpMethod.GET, 
	            null, 
	            new ParameterizedTypeReference<List<Meeting>>() {}
	            );
		List<Meeting> meetingList = response.getBody();
		log.info("getAllMeetings() executed successfully ");
		return meetingList;
	}

	@Override
	public List<Object[]> getAllDepartmentMettingsCount() {
		log.info("getAllDepartmentMettingsCount() is entered");
		log.info("getAllDepartmentMettingsCount() is under execution...");
		ResponseEntity<List<Object[]>> response = restTemplate.exchange(
	            this.meetingMicroserviceMeetingControllerURL+"/dept-count", 
	            HttpMethod.GET, 
	            null, 
	            new ParameterizedTypeReference<List<Object[]>>() {}
	            );
		List<Object[]> meetingCount = response.getBody();
		log.info("getAllDepartmentMettingsCount() executed successfully");
		return meetingCount;
		
	}

	
}
