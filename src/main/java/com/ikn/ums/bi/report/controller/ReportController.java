package com.ikn.ums.bi.report.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikn.ums.bi.report.model.Task;
import com.ikn.ums.bi.report.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	private ReportService reportService;

//	By Department Critical/High Tasks
//	Tasks Aging Report
//	Tasks By Due Date
//  General Reports
	
//	Master Tasks Report -- DONE
//	Aging Tasks Report ----- given a date, since then the open tasks list to be displayed
//	TasksReport ---- All the tasks shall be listed, and the Priority will be a drop down to play around
//	Department Wise Report ---- All the tasks w.r.t department shall be pulled out
//	TaskAssigneeReport ---- Report assignee wise, select the assignee and list all the tasks he/she owns
	
	
	@GetMapping("/tasks/all")
	public ResponseEntity<?> getTasksList() {
		List<Task> totalTaskList = reportService.getTasksList();
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
	
	@GetMapping("/tasks/dept")
	public ResponseEntity<?> getTasksListByDepartment(@RequestParam(defaultValue = "" , required = false) String department) {
		return null;
		//TODO: Get all the tasks as objects and set in the list and give to front end.

	}

	@GetMapping("/tasks/owner")
	public ResponseEntity<?> getTasksListByOwner(@RequestParam(defaultValue = "" , required = false) String taskOwner) {
		return null;
		//TODO: Get all the tasks as objects and set in the list and give to front end.

	}
	
	@GetMapping("/tasks/severity")
	public ResponseEntity<?> getTasksListBySeverity(@RequestParam(defaultValue = "" , required = false) String serverityLevel) {
		return null;
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}
	
	@GetMapping("/tasks/status")
	public ResponseEntity<?> getTasksListByStatus(@RequestParam(defaultValue = "" , required = false) String taskStatus) {
		return null;
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}
	
	
	@GetMapping("/tasks/date")
	public ResponseEntity<?> getAgedTasksList(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return null;
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}
	
	@GetMapping("/meeting/participant")
	public ResponseEntity<?> getParticipantTotalHoursSpentInMeetings(@RequestParam(defaultValue = "" , required = false) String participant) {
		return null;
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}	
	
	/**
	 * This method gets the Participants total hours spent by department wise.
	 * @param department: if value present, it gets the data for that department
	 * @return
	 */
	@GetMapping("/meeting/department")
	public ResponseEntity<?> getParticipantTotalHoursSpentInMeetingsByDepartment(@RequestParam(defaultValue = "" , required = false) String department) {
		return null;
		//TODO: Get all the tasks as objects and set in the list and give to front end.
	}	
	

	
//	
//	
//    @GetMapping("/reports/taskType}")
//    public ResponseEntity<List<Report>> getReportsByType(@PathVariable String taskType) {
//        List<Report> reports = reportService.getReportsByTaskType(taskType);
//        return ResponseEntity.ok(reports);
//    }
//
//    @GetMapping("/severity/{severity}")
//    public ResponseEntity<List<Report>> getReportsBySeverity(@PathVariable String severity) {
//        List<Report> reports = reportService.getReportsBySeverity(severity);
//        return ResponseEntity.ok(reports);
//    }
//    
//	
//	@GetMapping("/aged/{date}")
//    public ResponseEntity<List<Report>> getAgedReports(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        List<Report> reports = reportService.getAgedReports(date);
//        return ResponseEntity.ok(reports);
//    }
//	
	
}
