package com.ikn.ums.bi.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> getActionItemsReportByOrganizer(@RequestParam(required = true) String organizer) {
		log.info("getMeetingsByOrganizer entered");
		List<ActionItem> organizerActionItemList = actionItemReportServiceImpl.getActionItemsByOrganizer(organizer);
		return new ResponseEntity<>(organizerActionItemList, HttpStatus.OK);
	}	
	
	/**
	 * @param department: if value present, it gets the data for that department
	 * @return
	 */
	@GetMapping("/department")
	public ResponseEntity<?> getActionItemsReportByDepartment(@RequestParam(required = true) Long departmentId) {
		log.info("getMeetingsByDepartment entered");
		List<ActionItem> departmentActionItemList = actionItemReportServiceImpl.getActionItemsByDepartment(departmentId);
		return new ResponseEntity<>(departmentActionItemList, HttpStatus.OK);
	}	
	
	/**
	 * @param department: if value present, it gets the data for the prioroty
	 * @return
	 */
	@GetMapping("/priority")
	public ResponseEntity<?> getActionItemsReportByPriority(@RequestParam(required = true) String priority) {
		log.info("getMeetingsByDepartment entered");
		List<ActionItem> departmentActionItemList = actionItemReportServiceImpl.getActionItemsByPriority(priority);
		return new ResponseEntity<>(departmentActionItemList, HttpStatus.OK);
	}	

}
