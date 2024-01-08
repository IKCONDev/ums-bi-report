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
import com.ikn.ums.bi.report.model.ActionItem;
import com.ikn.ums.bi.report.service.ActionItemReportService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ActionItemReportServiceImpl implements ActionItemReportService {

	@Autowired
	private RestTemplate restTemplate;

	private String meetingMicroserviceActionItemControllerURL = "http://UMS-MEETING-SERVICE/actions";

	@Override
	public List<ActionItem> getActionItemsByOrganizer(String organizer) {
		log.info("getActionItemsByOrganizer() is entered");
		if(organizer == null || organizer == "") {
			log.info("getActionItemsByOrganizer() EmptyInputException: "+ organizer);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_MSG);
		}
		log.info("getActionItemsByOrganizer() is under execution...");
		ResponseEntity<List<ActionItem>> response = restTemplate.exchange(
				meetingMicroserviceActionItemControllerURL + "/all/" + organizer, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ActionItem>>() {
				});
		List<ActionItem> actionItemListOfOrganizer = response.getBody();
		log.info("getActionItemsByOrganizer() executed successfully");
		return actionItemListOfOrganizer;
	}

	@Override
	public List<ActionItem> getActionItemsByDepartment(Long departmentId) {
		log.info("getActionItemsByDepartment() is entered");
		if(departmentId <= 0 || departmentId == null) {
			log.info("getActionItemsByDepartment() EmptyInputException"+ departmentId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_MSG);
		}
		log.info("getActionItemsByDepartment() is under execution...");
		ResponseEntity<List<ActionItem>> response = restTemplate.exchange(
				meetingMicroserviceActionItemControllerURL + "/all/department/" + departmentId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ActionItem>>() {
				});
		List<ActionItem> actionItemListOfDepartment = response.getBody();
		log.info("getActionItemsByDepartment() executed successfully");
		return actionItemListOfDepartment;
	}

	@Override
	public List<ActionItem> getActionItemsByPriority(String priority) {
		log.info("getActionItemsByPriority() is entered");
		if(priority == null || priority == "") {
			log.info("getActionItemsByPriority() EmptyInputException: "+ priority);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_PRIORITY_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_PRIORITY_IS_NULL_MSG);
		}
		log.info("getActionItemsByPriority() is under execution...");
		ResponseEntity<List<ActionItem>> response = restTemplate.exchange(
				meetingMicroserviceActionItemControllerURL + "/all/priority/" + priority, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ActionItem>>() {
				});
		List<ActionItem> actionItemListByPriority = response.getBody();
		log.info("getActionItemsByPriority() executed successfully");
		return actionItemListByPriority;
	}
	@Override
	public List<Object[]> getAllDepartmentActionItemsCount() {
		log.info("getAllDepartmentActionItemsCount() is entered");
		log.info("getAllDepartmentActionItemsCount() is under execution...");
		ResponseEntity<List<Object[]>> response = restTemplate.exchange(
	            this.meetingMicroserviceActionItemControllerURL+"/department-actions", 
	            HttpMethod.GET, 
	            null, 
	            new ParameterizedTypeReference<List<Object[]>>() {}
	            );
		List<Object[]> actionItemsCount = response.getBody();
		log.info("getAllDepartmentActionItemsCount() executed successfully");
		return actionItemsCount;
	}

}
