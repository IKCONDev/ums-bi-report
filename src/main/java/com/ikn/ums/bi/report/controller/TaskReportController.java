package com.ikn.ums.bi.report.controller;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.ikn.ums.bi.report.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/taskReports")
public class TaskReportController {
	
	@Autowired
	private TaskService reportService;

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/tasks/all")
	public ResponseEntity<List<Long>> getTasksList(@RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate ,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
		log.info("getTasksList() is entered with args :");
		if(startDate == null || endDate == null) {
		  throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DATE_IS_NULL_CODE,
				  ErrorCodeMessages.ERR_REPORT_DATE_IS_NULL_MSG);	
		}
		try {
			log.info("getTasksList() is under execution...");
			List<Long> totalTaskList = reportService.getTasksListCount(startDate,endDate);
			log.info("getTasksList() executed successfully");
			return new ResponseEntity<>(totalTaskList, HttpStatus.OK);
		}catch (Exception e) {
		   log.error("getTasksList() is exited with an exception "+ e.getMessage(), e);
		   throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_CODE,
				   ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_MSG);
		}
		
	}
	
	/**
	 * 
	 * @param departmentId
	 * @return
	 */
	@GetMapping("/tasks/dept")
	public ResponseEntity<List<Task>> getTasksListByDepartment(@RequestParam(defaultValue = "" , required = false) Long departmentId) {
		log.info("getTasksListByDepartment is entered with args: departmentId - "+departmentId);
		if(departmentId <= 0 || departmentId == null) {
			log.info("getActionItemsReportByDepartment() EmptyInputException"+ departmentId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_MSG);
		}
		try {
			log.info("getTasksListByDepartment() is under execution...");
			List<Task> taskList = reportService.getTasksListByDepartment(departmentId);
			log.info("getTasksListByDepartment() executed successfully");
			return new ResponseEntity<>(taskList, HttpStatus.OK);
		}catch (Exception e) {
			log.error("getTasksListByDepartment() is exited with exception"+ e.getMessage());
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_CODE,
					   ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_MSG);
		}
		
	}

	/**
	 * 
	 * @param taskOwner
	 * @return
	 */
	@GetMapping("/tasks/owner")
	public ResponseEntity<List<Task>> getTasksListByOwner(@RequestParam(defaultValue = "" , required = false) String taskOwner) {
		log.info("getTasksListByOwner is entered with args : taskOwner - "+ taskOwner);
		if(taskOwner == null) {
			log.info("getTasksListByOwner() EmptyInputException"+ taskOwner);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_TASKOWNER_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_TASKOWNER_IS_NULL_MSG);
		}
		try {
			log.info("getTasksListByOwner() is under execution...");
			List<Task> taskList = reportService.getTasksListByOwner(taskOwner);
			log.info("getTasksListByOwner() executed successfully");
			return new ResponseEntity<>(taskList, HttpStatus.OK);
			
		}catch(Exception e) {
			log.error("getTasksListByOwner() exited with exception: "+ e.getMessage());
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_CODE,
					   ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_MSG);
		}
		

	}
	
	/**
	 * 
	 * @param serverityLevel
	 * @return
	 */
	@GetMapping("/tasks/severity")
	public ResponseEntity<List<Task>> getTasksListBySeverity(@RequestParam(defaultValue = "" , required = false) String serverityLevel) {
		log.info("getTasksListBySeverity() is entered with args : severity ");
		if(serverityLevel == null) {
		  log.info("getTasksListBySeverity() EmptyInputException"+ serverityLevel);	
		  throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_SEVERITY_IS_NULL_CODE,
				  ErrorCodeMessages.ERR_REPORT_SEVERITY_IS_NULL_MSG);
		}
		try {
			log.info("getTasksListBySeverity() is under execution...");
			List<Task> taskList = reportService.getTasksListBySeverity(serverityLevel);
			log.info("getTasksListBySeverity() executed successfully");
			return new ResponseEntity<>(taskList, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("getTasksListBySeverity() is exited with exception");
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_CODE,
					   ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_MSG);
		}
	
	}
	
	/**
	 * 
	 * @param taskStatus
	 * @return
	 */
	@GetMapping("/tasks/status")
	public ResponseEntity<List<Task>> getTasksListByStatus(@RequestParam(defaultValue = "" , required = false) String taskStatus) {
		log.info("getTasksListByStatus is entered with args : status");
		if(taskStatus == null) {
			log.info("getTasksListByStatus() EmptyInputException "+ taskStatus);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_STATUS_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_STATUS_IS_NULL_MSG);
		}
		try {
			log.info("getTasksListByStatus() is under execution...");
			List<Task> taskList = reportService.getTasksListByStatus(taskStatus);
			log.info("getTasksListByStatus() executed successfully");
			return new ResponseEntity<>(taskList, HttpStatus.OK);
		}catch (Exception e) {
		   log.error("getTasksListByStatus() is exited with exception"+ e.getMessage(), e);
		   throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_CODE,
				   ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_MSG);
		}
	
	}
	
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	@GetMapping("/tasks/aged")
	public ResponseEntity<List<Task>> getAgedTasksList(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
		log.info("getAgedTasksList() is entered with args: date - "+ date );
		if(date == null) {
			log.info("getAgedTasksList() EmptyInputException "+ date);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DATE_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DATE_IS_NULL_MSG);
		}
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
		//LocalDateTime dateTimeNow = LocalDateTime.parse(dateTime.toString(),formatter);
		try {
			log.info("getAgedTasksList() is under execution...");
			List<Task> taskList = reportService.getAgedTasksList(date);
			log.info("getAgedTasksList() executed successfully");
			return new ResponseEntity<>(taskList, HttpStatus.OK);
		}catch (Exception e) {
			log.error("getAgedTasksList() is exited with Exception"+e.getMessage(), e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_CODE,
					   ErrorCodeMessages.ERR_REPORT_GET_TASKS_UNSUCCESS_MSG);
		}
		
	}
	
	@GetMapping("/task/department-task")
	public ResponseEntity<List<Object[]>> getAllDepartmentsTasksCount(){
		log.info("getAllDepartmentsMeetingsCount() is entered");
        try {
        	log.info("getAllDepartmentsMeetingsCount() is under execution...");
    		List<Object[]> DeptTasksCount = reportService.getAllDepartmentTasksCount();
    		log.info("getAllDepartmentsMeetingsCount() executed successfully");
    		return new ResponseEntity<>(DeptTasksCount, HttpStatus.OK);
			
		}catch(Exception e) {
			log.error("getAllDepartmentsTasksCount() exited with exception:"+ e.getMessage());
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_MSG);
			
		}
		
	}

}
