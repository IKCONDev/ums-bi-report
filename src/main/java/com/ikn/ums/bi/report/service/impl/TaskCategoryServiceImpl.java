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
import com.ikn.ums.bi.report.model.Task;
import com.ikn.ums.bi.report.service.TaskCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskCategoryServiceImpl  implements TaskCategoryService{

	private String meetingMicroserviceTaskControllerURL = "http://UMS-MEETING-SERVICE/task";
	
	@Autowired
	private RestTemplate restTemplate;
	
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
