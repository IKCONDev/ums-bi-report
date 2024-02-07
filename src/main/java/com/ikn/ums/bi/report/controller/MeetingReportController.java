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
import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.service.MeetingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reports")
public class MeetingReportController {
	
	@Autowired
	private MeetingService reportService;

	/**
	 * 
	 * @param organizerName
	 * @return
	 */
	@GetMapping("/meeting/organizer")
	public ResponseEntity<List<Meeting>> getMeetingsByOrganizer(@RequestParam(defaultValue = "" , required = false) String organizer) {
		log.info("getMeetingsByOrganizer() is entered with args : organizer");
		if(organizer == null || organizer == "") {
			log.info("getMeetingsByOrganizer() EmptyInputException: "+ organizer);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_MSG);
		}
		try {
			log.info("getMeetingsByOrganizer() is under execution...");
			List<Meeting> organizerMeetingList = reportService.getMeetingsByOrganizer(organizer);
			log.info("getMeetingsByOrganizer() executed successfully");
			return new ResponseEntity<>(organizerMeetingList, HttpStatus.OK);
			
		}catch(Exception e) {
			log.error("getMeetingsByOrganizer() exited with exception "+ e.getMessage(), e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_CODE,
					ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_MSG);
		}
		
	}	
	
	/**
	 * @param department: if value present, it gets the data for that department
	 * @return
	 */
	@GetMapping("/meeting/department")
	public ResponseEntity<List<Meeting>> getMeetingsByDepartment(@RequestParam(defaultValue = "" , required = false) Long departmentId) {
		log.info("getMeetingsByDepartment is entered with args: departmentId");
		if(departmentId <= 0 || departmentId == null) {
			log.info("getActionItemsReportByDepartment() EmptyInputException"+ departmentId);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DEPARTMENTID_IS_NULL_MSG);
		}
		try {
			log.info("getActionItemsReportByDepartment() is under execution...");
			List<Meeting> departmentMeetingList = reportService.getMeetingsByDepartment(departmentId);
			log.info("getActionItemsReportByDepartment() executed successfully");
			return new ResponseEntity<>(departmentMeetingList, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("getActionItemsReportByDepartment() exited with exception:"+ e.getMessage(), e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_CODE,
					ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_MSG);
		}
		
	}	
	
	@GetMapping("/meeting/attendee")
	public ResponseEntity<List<Meeting>> getMeetingsByAttendee(@RequestParam(required = true) String attendee){
		log.info("getmeetingsByAttendee() is entered with args: attendee");
		if(attendee == null) {
			log.info("getMeetingsByAttendee() EmptyInputException"+ attendee);
			throw new EmptyInputException(ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_EMAILID_IS_NULL_MSG);
		}
		try {
			log.info("getMeetingsByAttendee() is under execution...");
			List<Meeting> attendedMeetingList = reportService.getMeetingsByAttendee(attendee);
			log.info("getMeetingsByAttendee() executed successfully");
			return new ResponseEntity<>(attendedMeetingList, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("getMeetingsByAttendee() exited with exception:"+ e.getMessage(),e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_CODE,
					ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_MSG);
		}
		
	}
	
	@GetMapping("/meeting/all")
	public ResponseEntity<List<Meeting>> getAllMeetings(){
		log.info("getAllMeetings() is entered");
        try {
        	log.info("getAllMeetings() is under execution...");
    		List<Meeting> attendedMeetingList = reportService.getAllMeetings();
    		log.info("getAllMeetings() executed successfully");
    		return new ResponseEntity<>(attendedMeetingList, HttpStatus.OK);
		}catch(Exception e) {
			log.error("getAllMeetings() exited with exception:"+ e.getMessage(), e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_CODE,
					ErrorCodeMessages.ERR_REPORT_GET_MEETINGS_UNSUCCESS_MSG);
		}
	}
	
	@GetMapping("/meeting/count")
	public ResponseEntity<List<Object[]>> getAllDepartmentsMeetingsCount(){
		log.info("getAllDepartmentsMeetingsCount() is entered");
        try {
        	log.info("getAllDepartmentsMeetingsCount() is under execution...");
    		List<Object[]> DeptmeetingCount = reportService.getAllDepartmentMettingsCount();
    		log.info("getAllDepartmentsMeetingsCount() executed successfully");
    		return new ResponseEntity<>(DeptmeetingCount, HttpStatus.OK);
		}catch(Exception e) {
			log.error("getAllDepartmentsMeetingsCount() exited with exception:"+ e.getMessage(), e);
			throw new ControllerException(ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_CODE,
					ErrorCodeMessages.ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_MSG);
		}
		
	}
	
	
	
}
