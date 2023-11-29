package com.ikn.ums.bi.report.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.ums.bi.report.model.DepartmentMeetingCount;
import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.model.Task;
import com.ikn.ums.bi.report.service.ReportService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private RestTemplate restTemplate;
	private String meetingMicroserviceTaskControllerURL = "http://UMS-MEETING-SERVICE/task";
	private String meetingMicroserviceMeetingControllerURL = "http://UMS-MEETING-SERVICE/meetings";

	@Override
	public List<Long> getTasksListCount(@DateTimeFormat(iso =ISO.DATE_TIME) LocalDateTime startDate,@DateTimeFormat(iso =ISO.DATE_TIME)  LocalDateTime endDate) {
		System.out.println(startDate+"  "+"+++++++++");
		String url = this.meetingMicroserviceTaskControllerURL + "/allForYear/" +startDate +"/"+ endDate;
		ResponseEntity<List<Long>> response = restTemplate.exchange(url, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Long>>() {});
		
		List<Long> taskList = response.getBody();
		System.out.println(taskList);
		return taskList;
	}
	
	@Override
	public List<Task> getTasksListByDepartment(Long departmentId) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/department/"+departmentId, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Task>>() {
		});
		System.out.println(response.getBody());
		List<Task> taskListByDepartment = response.getBody();
		return taskListByDepartment;
	}

	@Override
	public List<Task> getTasksListByOwner(String taskOwner) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/assigned/"+taskOwner, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListByOwner = response.getBody();
		return taskListByOwner;
	}

	@Override
	public List<Task> getTasksListBySeverity(String serverityLevel) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/priority/"+serverityLevel, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListBySeverity = response.getBody();
		return taskListBySeverity;
	}

	@Override
	public List<Task> getTasksListByStatus(String taskStatus) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/status/"+taskStatus, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListByStatus = response.getBody();
		return taskListByStatus;
	}

	@Override
	public List<Task> getAgedTasksList(LocalDate date) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/aged/"+date.toString(), 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> agedTaskList = response.getBody();
		return agedTaskList;
	}

	@Override
	public List<Meeting> getMeetingsByOrganizer(String organizer) {
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(this.meetingMicroserviceMeetingControllerURL+"/organized/"+organizer, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>() {
				});
		List<Meeting> organizerMeetingList = response.getBody();
		return organizerMeetingList;
	}

	@Override
	public List<Meeting> getMeetingsByDepartment(Long departmentId) {
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(this.meetingMicroserviceMeetingControllerURL+"/department/"+departmentId, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>() {
				});
		List<Meeting> meetingListOfDepartment = response.getBody();
		return meetingListOfDepartment;
	}

	@Override
	public List<Meeting> getMeetingsByAttendee(String attendee) {
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(this.meetingMicroserviceMeetingControllerURL+"/attended/"+attendee, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>() {
				});
		List<Meeting> attendeeMeetingList = response.getBody();
		return attendeeMeetingList;
	}

	@Override
	public List<Meeting> getAllMeetings() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Meeting>> response = restTemplate.exchange(
	            this.meetingMicroserviceMeetingControllerURL+"/all", 
	            HttpMethod.GET, 
	            null, 
	            new ParameterizedTypeReference<List<Meeting>>() {}
	            );
		List<Meeting> meetingList = response.getBody();
		return meetingList;
	}

	@Override
	public List<Object[]> getAllDepartmentMettingsCount() {
		// TODO Auto-generated method stub
		log.info("getAllDepartmentMettingsCount() is entered");
		log.info("getAllDepartmentMettingsCount() is under execution...");
		ResponseEntity<List<Object[]>> response = restTemplate.exchange(
	            this.meetingMicroserviceMeetingControllerURL+"/dept-count", 
	            HttpMethod.GET, 
	            null, 
	            new ParameterizedTypeReference<List<Object[]>>() {}
	            );
		List<Object[]> meetingCount = response.getBody();
		return meetingCount;
		
	}

	@Override
	public List<Object[]> getAllDepartmentTasksCount() {
		// TODO Auto-generated method stub
		log.info("getAllDepartmentTasksCount() is entered");
		log.info("getAllDepartmentTasksCount() is under execution...");
		ResponseEntity<List<Object[]>> response = restTemplate.exchange(
	            this.meetingMicroserviceTaskControllerURL+"/department-tasks", 
	            HttpMethod.GET, 
	            null, 
	            new ParameterizedTypeReference<List<Object[]>>() {}
	            );
		List<Object[]> TasksCount = response.getBody();
		return TasksCount;
	}

}
