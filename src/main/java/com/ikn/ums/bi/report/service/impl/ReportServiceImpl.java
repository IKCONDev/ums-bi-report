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

import com.ikn.ums.bi.report.exception.EmptyInputException;
import com.ikn.ums.bi.report.exception.ErrorCodeMessages;
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
		log.info("getTasksListCount() is entered");
		log.info("getTasksListCount() is under execution...");
		String url = this.meetingMicroserviceTaskControllerURL + "/allForYear/" +startDate +"/"+ endDate;
		ResponseEntity<List<Long>> response = restTemplate.exchange(url, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Long>>() {});
		
		List<Long> taskList = response.getBody();
		System.out.println(taskList);
		log.info("getTasksListCount() executed successfully");
		return taskList;
	}
	
	@Override
	public List<Task> getTasksListByDepartment(Long departmentId) {
		log.info("getTasksListByDepartment() is entered");
		if(departmentId <= 0 || departmentId == null) {
			log.info("getActionItemsByDepartment() EmptyInputException"+ departmentId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_MSG);
		}
		log.info("getTasksListByDepartment() is under execution...");
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/department/"+departmentId, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Task>>() {
		});
		List<Task> taskListByDepartment = response.getBody();
		log.info("getTasksListByDepartment() executed successfully");
		return taskListByDepartment;
	}

	@Override
	public List<Task> getTasksListByOwner(String taskOwner) {
		log.info("getTasksListByOwner() is entered");
		if(taskOwner == null) {
			log.info("getTasksListByOwner() EmptyInputException"+ taskOwner);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_TASKOWNER_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_TASKOWNER_IS_NULL_MSG);
		}
		log.info("getTasksListByOwner() is under execution...");
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/assigned/"+taskOwner, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListByOwner = response.getBody();
		log.info("getTasksListByOwner() executed successfully");
		return taskListByOwner;
	}

	@Override
	public List<Task> getTasksListBySeverity(String serverityLevel) {
		log.info("getTasksListBySeverity() is entered");
		if(serverityLevel == null) {
			  log.info("getTasksListBySeverity() EmptyInputException"+ serverityLevel);	
			  throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_SEVERITY_IS_NULL_CODE,
					  ErrorCodeMessages.ERR_REPORT_SEVERITY_IS_NULL_MSG);
			}
		log.info("getTasksListBySeverity() is under execution...");
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/priority/"+serverityLevel, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListBySeverity = response.getBody();
		log.info("getTasksListBySeverity() executed successfully");
		return taskListBySeverity;
	}

	@Override
	public List<Task> getTasksListByStatus(String taskStatus) {
		log.info("getTasksListByStatus() is entered");
		if(taskStatus == null) {
			log.info("getTasksListByStatus() EmptyInputException "+ taskStatus);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_STATUS_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_STATUS_IS_NULL_MSG);
		}
		log.info("getTasksListByStatus() is under execution...");
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/status/"+taskStatus, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListByStatus = response.getBody();
		log.info("getTasksListByStatus() executed successfully ");
		return taskListByStatus;
	}

	@Override
	public List<Task> getAgedTasksList(LocalDate date) {
		log.info("getAgedTasksList() is entered");
		if(date == null) {
			log.info("getAgedTasksList() EmptyInputException "+ date);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DATE_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DATE_IS_NULL_MSG);
		}
		log.info("getAgedTasksList() is under execution...");
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.meetingMicroserviceTaskControllerURL+"/aged/"+date.toString(), 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> agedTaskList = response.getBody();
		log.info("getAgedTasksList() executed successfully ");
		return agedTaskList;
	}

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

	@Override
	public List<Object[]> getAllDepartmentTasksCount() {
		log.info("getAllDepartmentTasksCount() is entered");
		log.info("getAllDepartmentTasksCount() is under execution...");
		ResponseEntity<List<Object[]>> response = restTemplate.exchange(
	            this.meetingMicroserviceTaskControllerURL+"/department-tasks", 
	            HttpMethod.GET, 
	            null, 
	            new ParameterizedTypeReference<List<Object[]>>() {}
	            );
		List<Object[]> TasksCount = response.getBody();
		log.info("getAllDepartmentTasksCount() executed successfully");
		return TasksCount;
	}

	@Override
	public List<Object[]> getAllTaskCategoryCount() {
		log.info("getAllTaskCategoryCount() is entered");
		log.info("getAllTaskCategoryCount() is under execution...");
		ResponseEntity<List<Object[]>> response = restTemplate.exchange(meetingMicroserviceTaskControllerURL+"/taskCategory-count",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Object[]>>() {}
		);
		List<Object[]> tasksList = response.getBody();
		log.info("getAllTaskCategoryCount() executed successfully");
		return tasksList;
	}
	@Override
	public List<Task> getAllTasksByCategoryId(Long taskCategoryId){
		log.info("getAllTasksByCategoryId() is entered");
		if(taskCategoryId <= 0 || taskCategoryId == null) {
			log.info("getAllTasksByCategoryId() EmptyInputException"+ taskCategoryId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_TASKCATEGORY_ID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_TASKCATEGORY_ID_IS_NULL_MSG);
		}
		log.info("getAllTasksByCategoryId() is under execution...");
		ResponseEntity<List<Task>> response = restTemplate.exchange(meetingMicroserviceTaskControllerURL+"/taskCategory/"+taskCategoryId,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {}
		);
		List<Task> tasksList = response.getBody();
		log.info("getAllTasksByCategoryId() executed successfully");
		return tasksList;
		
	}

}
