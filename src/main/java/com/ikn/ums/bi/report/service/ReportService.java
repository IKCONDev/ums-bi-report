package com.ikn.ums.bi.report.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.ikn.ums.bi.report.model.DepartmentMeetingCount;
import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.model.Task;

public interface ReportService {
	
	
	public List<Task> getTasksListByDepartment(Long departmentId);
	public List<Task> getTasksListByOwner(String taskOwner);
	public List<Task> getTasksListBySeverity(String serverityLevel);
	public List<Task> getTasksListByStatus(String taskStatus);
	public List<Task> getAgedTasksList(LocalDate dateTime);
	public List<Meeting> getMeetingsByOrganizer(String organizer);
	public List<Meeting> getMeetingsByAttendee(String attendee);
	public List<Meeting> getMeetingsByDepartment(Long departmentId);
	public List<Long> getTasksListCount(LocalDateTime startDate, LocalDateTime endDate);
	public List<Meeting> getAllMeetings();
	//public List<DepartmentMeetingCount> getAllDepartmentMettingsCount();
	public List<Object[]> getAllDepartmentMettingsCount();

}
