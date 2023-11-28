package com.ikn.ums.bi.report.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikn.ums.bi.report.model.DepartmentMeetingCount;
import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.model.Task;
import com.ikn.ums.bi.report.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	private ReportService reportService;

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/tasks/all")
	public ResponseEntity<?> getTasksList(@RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate ,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
		List<Long> totalTaskList = reportService.getTasksListCount(startDate,endDate);
		return new ResponseEntity<>(totalTaskList, HttpStatus.OK);
		
		
		//TODO: Get all the tasks as objects and set in the list and give to front end.
		
	//	return new ResponseEntity<>(rolesList, HttpStatus.OK);
//		log.info("RoleController.getAllRoles() ENTERED.");
//		try {
//			log.info("RoleController.getAllRoles() is under execution...");
//			List<Role> rolesList = roleService.getAllRoles();
//			log.info("RoleController.getAllRoles() executed successfully");
//			return new ResponseEntity<>(rolesList, HttpStatus.OK);
//		}catch (EmptyListException businessException) {
//			throw businessException;
//		} 
//		catch (Exception e) {
//			// TODO: handle exception
//			log.info("RoleController.getAllRoles() exited with exception : Exception occured fetching roles list."
//					+ e.getMessage());
//			throw new ControllerException(ErrorCodeMessages.ERR_ROLE_LIST_IS_EMPTY_CODE,
//					ErrorCodeMessages.ERR_ROLE_LIST_IS_EMPTY_MSG);
//		}
	}
	
	/**
	 * 
	 * @param departmentId
	 * @return
	 */
	@GetMapping("/tasks/dept")
	public ResponseEntity<?> getTasksListByDepartment(@RequestParam(defaultValue = "" , required = false) Long departmentId) {
		log.info("getTasksListByDepartment entered");
		List<Task> taskList = reportService.getTasksListByDepartment(departmentId);
		return new ResponseEntity<>(taskList, HttpStatus.OK);
	}

	/**
	 * 
	 * @param taskOwner
	 * @return
	 */
	@GetMapping("/tasks/owner")
	public ResponseEntity<?> getTasksListByOwner(@RequestParam(defaultValue = "" , required = false) String taskOwner) {
		log.info("getTasksListByOwner entered");
		List<Task> taskList = reportService.getTasksListByOwner(taskOwner);
		return new ResponseEntity<>(taskList, HttpStatus.OK);
		//TODO: Get all the tasks as objects and set in the list and give to front end.

	}
	
	/**
	 * 
	 * @param serverityLevel
	 * @return
	 */
	@GetMapping("/tasks/severity")
	public ResponseEntity<?> getTasksListBySeverity(@RequestParam(defaultValue = "" , required = false) String serverityLevel) {
		log.info("getTasksListBySeverity entered");
		List<Task> taskList = reportService.getTasksListBySeverity(serverityLevel);
		return new ResponseEntity<>(taskList, HttpStatus.OK);
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}
	
	/**
	 * 
	 * @param taskStatus
	 * @return
	 */
	@GetMapping("/tasks/status")
	public ResponseEntity<?> getTasksListByStatus(@RequestParam(defaultValue = "" , required = false) String taskStatus) {
		log.info("getTasksListByStatus entered");
		List<Task> taskList = reportService.getTasksListByStatus(taskStatus);
		return new ResponseEntity<>(taskList, HttpStatus.OK);
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}
	
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	@GetMapping("/tasks/aged")
	public ResponseEntity<?> getAgedTasksList(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		log.info("getAgedTasksList entered");
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
		//LocalDateTime dateTimeNow = LocalDateTime.parse(dateTime.toString(),formatter);
		List<Task> taskList = reportService.getAgedTasksList(date);
		return new ResponseEntity<>(taskList, HttpStatus.OK);
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}
	
	/**
	 * 
	 * @param organizerName
	 * @return
	 */
	@GetMapping("/meeting/organizer")
	public ResponseEntity<?> getMeetingsByOrganizer(@RequestParam(defaultValue = "" , required = false) String organizer) {
		log.info("getMeetingsByOrganizer entered");
		List<Meeting> organizerMeetingList = reportService.getMeetingsByOrganizer(organizer);
		return new ResponseEntity<>(organizerMeetingList, HttpStatus.OK);
	}	
	
	/**
	 * @param department: if value present, it gets the data for that department
	 * @return
	 */
	@GetMapping("/meeting/department")
	public ResponseEntity<?> getMeetingsByDepartment(@RequestParam(defaultValue = "" , required = false) Long departmentId) {
		log.info("getMeetingsByDepartment entered");
		List<Meeting> departmentMeetingList = reportService.getMeetingsByDepartment(departmentId);
		return new ResponseEntity<>(departmentMeetingList, HttpStatus.OK);
	}	
	
	@GetMapping("/meeting/attendee")
	public ResponseEntity<?> getMeetingsByAttendee(@RequestParam(required = true) String attendee){
		log.info("getmeetingsByAttendee entered");
		List<Meeting> attendedMeetingList = reportService.getMeetingsByAttendee(attendee);
		return new ResponseEntity<>(attendedMeetingList, HttpStatus.OK);
	}
	
	@GetMapping("/meeting/all")
	public ResponseEntity<?> getAllMeetings(){
		log.info("getAllMeetings() is entered");
		log.info("getAllMeetings() is under execution...");
		List<Meeting> attendedMeetingList = reportService.getAllMeetings();
		return new ResponseEntity<>(attendedMeetingList, HttpStatus.OK);
	}
	
	@GetMapping("/meeting/count")
	public ResponseEntity<?> getAllDepartmentsMeetingsCount(){
		log.info("getAllDepartmentsMeetingsCount() is entered");
		log.info("getAllDepartmentsMeetingsCount() is under execution...");
		List<Object[]> DeptmeetingCount = reportService.getAllDepartmentMettingsCount();
		System.out.println(DeptmeetingCount);
		return new ResponseEntity<>(DeptmeetingCount, HttpStatus.OK);
	}
}
