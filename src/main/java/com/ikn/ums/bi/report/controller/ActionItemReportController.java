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
import com.ikn.ums.bi.report.exception.EmptyListException;
import com.ikn.ums.bi.report.exception.ErrorCodeMessages;
import com.ikn.ums.bi.report.model.ActionItem;
import com.ikn.ums.bi.report.service.ActionItemReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/actionReports")
public class ActionItemReportController {
	
	@Autowired
	private ActionItemReportService actionItemReportServiceImpl;
	
	@GetMapping("/organizer")
	public ResponseEntity<List<ActionItem>> getActionItemsReportByOrganizer(@RequestParam(required = true) String organizer) {
		log.info("getMeetingsByOrganizer() is entered with args: OrganizerName - "+ organizer);
		if(organizer == null || organizer == "") {
			log.info("getActionItemsReportByOrganizer() Organizer value is empty"+ organizer);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_MSG);
		}
		try {
			log.info("getMeetingsByOrganizer() is under execution...");
			List<ActionItem> organizerActionItemList = actionItemReportServiceImpl.getActionItemsByOrganizer(organizer);
			log.info("getMeetingsByOrganizer() executed successfully");
			return new ResponseEntity<>(organizerActionItemList, HttpStatus.OK);
		}catch (Exception e) {
			log.error("getActionItemsReportByOrganizer() An exception occured while fectching the action Items of an organizer"+ e.getMessage());
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_MSG);
		}
		
	}	
	
	/**
	 * @param department: if value present, it gets the data for that department
	 * @return
	 */
	@GetMapping("/department")
	public ResponseEntity<List<ActionItem>> getActionItemsReportByDepartment(@RequestParam(required = true) Long departmentId) {
		log.info("getMeetingsByDepartment() is entered with args: departmentId - "+ departmentId);
		if(departmentId <= 0 || departmentId == null) {
			log.info("getActionItemsReportByDepartment() EmptyInputException"+ departmentId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_MSG);
		}
		try {
			log.info("getActionItemsReportByDepartment() is under execution...");
			List<ActionItem> departmentActionItemList = actionItemReportServiceImpl.getActionItemsByDepartment(departmentId);
			log.info("getActionItemsReportByDepartment() executed successfully");
			return new ResponseEntity<>(departmentActionItemList, HttpStatus.OK);
		}catch (Exception e) {
			log.error("getActionItemsReportByDepartment() is exited with Exception "+ e.getMessage());
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_MSG);
		}
	}	
	
	/**
	 * @param department: if value present, it gets the data for the prioroty
	 * @return
	 */
	@GetMapping("/priority")
	public ResponseEntity<List<ActionItem>> getActionItemsReportByPriority(@RequestParam(required = true) String priority) {
		log.info("getMeetingsByDepartment is entered with args: priority");
		if(priority == null || priority == "") {
			log.info("getActionItemsReportByPriority() EmptyInputException: "+ priority);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_PRIORITY_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_PRIORITY_IS_NULL_MSG);
		}
		try {
			log.info("getMeetingsByDepartment is under executiom...");
			List<ActionItem> departmentActionItemList = actionItemReportServiceImpl.getActionItemsByPriority(priority);
			log.info("getMeetingsByDepartment executed successfully");
			return new ResponseEntity<>(departmentActionItemList, HttpStatus.OK);
		}catch(Exception e) {
			log.error("An exception occured while fetching the action Items based on priority"+ e.getMessage());
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_MSG);
			
		}
		
	}	
    
	@GetMapping("/department-actions")
	public ResponseEntity<List<Object[]>> getAllDepartmentsactionItemsCount(){
		log.info("getAllDepartmentsMeetingsCount() is entered");
		try {
			log.info("getAllDepartmentsMeetingsCount() is under execution...");
			List<Object[]> DeptActionItemsCount = actionItemReportServiceImpl.getAllDepartmentActionItemsCount();
			System.out.println(DeptActionItemsCount);
			log.info("getAllDepartmentsMeetingsCount() executed successfully");
			return new ResponseEntity<>(DeptActionItemsCount, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("getAllDepartmentsactionItemsCount() is exied with exception"+ e.getMessage());
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_MSG);
		}
		
	}
}
