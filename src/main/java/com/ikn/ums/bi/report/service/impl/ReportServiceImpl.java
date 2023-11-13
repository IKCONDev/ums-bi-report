package com.ikn.ums.bi.report.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
	public List<Task> getTasksList() {
		ResponseEntity<List<Task>> response = restTemplate.exchange(this.taskMicroserviceUrl+"/all", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {});
		List<Task> taskList = response.getBody();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksListBySeverity(String serverityLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksListByStatus(String taskStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAgedTasksList(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
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
