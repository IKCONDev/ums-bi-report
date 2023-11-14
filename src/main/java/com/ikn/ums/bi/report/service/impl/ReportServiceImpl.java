package com.ikn.ums.bi.report.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.model.Task;
import com.ikn.ums.bi.report.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private RestTemplate restTemplate;
	private String taskMicroserviceUrl = "http://UMS-MEETING-SERVICE/task";

	@Override
	public List<Long> getTasksListCount(@DateTimeFormat(iso =ISO.DATE_TIME) LocalDateTime startDate,@DateTimeFormat(iso =ISO.DATE_TIME)  LocalDateTime endDate) {
		System.out.println(startDate+"  "+"+++++++++");
		String url = this.taskMicroserviceUrl + "/allForYear/" +startDate +"/"+ endDate;
		ResponseEntity<List<Long>> response = restTemplate.exchange(url, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Long>>() {});
		
		List<Long> taskList = response.getBody();
		System.out.println(taskList);
		return taskList;
	}
	
	@Override
	public List<Task> getTasksListByDepartment(Long departmentId) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.taskMicroserviceUrl+"/department/"+departmentId, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Task>>() {
		});
		System.out.println(response.getBody());
		List<Task> taskListByDepartment = response.getBody();
		return taskListByDepartment;
	}

	@Override
	public List<Task> getTasksListByOwner(String taskOwner) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.taskMicroserviceUrl+"/assigned/"+taskOwner, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListByOwner = response.getBody();
		return taskListByOwner;
	}

	@Override
	public List<Task> getTasksListBySeverity(String serverityLevel) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.taskMicroserviceUrl+"/priority/"+serverityLevel, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListBySeverity = response.getBody();
		return taskListBySeverity;
	}

	@Override
	public List<Task> getTasksListByStatus(String taskStatus) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.taskMicroserviceUrl+"/status/"+taskStatus, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskListByStatus = response.getBody();
		return taskListByStatus;
	}

	@Override
	public List<Task> getAgedTasksList(LocalDateTime dateTime) {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.taskMicroserviceUrl+"/aged/"+dateTime.toString(), 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> agedTaskList = response.getBody();
		return agedTaskList;
	}

	@Override
	public List<Meeting> getParticipantTotalHoursSpentInMeetings(String participant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meeting> getParticipantTotalHoursSpentInMeetingsByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

	
	

}
