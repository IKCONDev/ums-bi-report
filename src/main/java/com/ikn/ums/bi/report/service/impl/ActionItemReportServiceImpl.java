package com.ikn.ums.bi.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.ums.bi.report.model.ActionItem;
import com.ikn.ums.bi.report.service.ActionItemReportService;

@Service
public class ActionItemReportServiceImpl implements ActionItemReportService {

	@Autowired
	private RestTemplate restTemplate;

	private String meetingMicroserviceActionItemControllerURL = "http://UMS-MEETING-SERVICE/actions";

	@Override
	public List<ActionItem> getActionItemsByOrganizer(String organizer) {
		ResponseEntity<List<ActionItem>> response = restTemplate.exchange(
				meetingMicroserviceActionItemControllerURL + "/all/" + organizer, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ActionItem>>() {
				});
		List<ActionItem> actionItemListOfOrganizer = response.getBody();
		return actionItemListOfOrganizer;
	}

	@Override
	public List<ActionItem> getActionItemsByDepartment(Long departmentId) {
		ResponseEntity<List<ActionItem>> response = restTemplate.exchange(
				meetingMicroserviceActionItemControllerURL + "/all/department/" + departmentId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ActionItem>>() {
				});
		List<ActionItem> actionItemListOfDepartment = response.getBody();
		return actionItemListOfDepartment;
	}

	@Override
	public List<ActionItem> getActionItemsByPriority(String priority) {
		ResponseEntity<List<ActionItem>> response = restTemplate.exchange(
				meetingMicroserviceActionItemControllerURL + "/all/priority/" + priority, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ActionItem>>() {
				});
		List<ActionItem> actionItemListByPriority = response.getBody();
		return actionItemListByPriority;
	}

}
