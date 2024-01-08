package com.ikn.ums.bi.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikn.ums.bi.report.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/taskCategoryReports")
public class TaskCategoryReportController {
	
	@Autowired
	private ReportService reportService;

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/tasksCategoryReport/all")
	public ResponseEntity<?> getAllTaskCategoryReportList() {
		
		return null;
		
		
	}

}
