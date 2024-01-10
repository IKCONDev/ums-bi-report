package com.ikn.ums.bi.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikn.ums.bi.report.exception.ControllerException;
import com.ikn.ums.bi.report.exception.EmptyInputException;
import com.ikn.ums.bi.report.exception.ErrorCodeMessages;
import com.ikn.ums.bi.report.model.Task;
import com.ikn.ums.bi.report.service.TaskCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/taskCategoryReports")
public class TaskCategoryReportController {
	
	@Autowired
    private TaskCategoryService reportService;
	
	@GetMapping("/task/all-categorycount")
	public ResponseEntity<List<Object[]>> getAllTaskCategoryCount(){
		log.info("getAllTasks() is entered");
		try {
			log.info("getAllTasks() is under execution...");
			List<Object[]> TaskList = reportService.getAllTaskCategoryCount();
			log.info("getAllTasks() executed successfully");
			return new ResponseEntity<>(TaskList, HttpStatus.OK);
		}catch(Exception e) {
			log.error("getAllTaskCategoryCount() exited with exception:"+ e.getMessage(), e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_MSG);
		}
		
	}
	@GetMapping("/task/category")
	public ResponseEntity<List<Task>> getTaskByCategoryId(@RequestParam(defaultValue ="", required=true) Long taskCategoryId){
		log.info("getTaskByCategoryId() is entered");
		if(taskCategoryId <= 0 || taskCategoryId == null) {
			log.info("getTaskByCategoryId() EmptyInputException"+ taskCategoryId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_TASKCATEGORY_ID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_TASKCATEGORY_ID_IS_NULL_MSG);
		}
		try {
			log.info("getTaskByCategoryId() is under execution...");
			List<Task> taskList = reportService.getAllTasksByCategoryId(taskCategoryId);
			log.info("getTaskByCategoryId() executed  successfully");
			return new ResponseEntity<>(taskList, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("getTaskByCategoryId() is exited with Exception"+e.getMessage(), e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_TASK_LIST_ENTITY_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_TASK_LIST_ENTITY_IS_NULL_MSG);
		}
	
	}

}
