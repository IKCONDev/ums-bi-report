package com.ikn.ums.bi.report.service;

import java.time.LocalDate;
import java.util.List;
import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.model.Task;

public interface ReportService {
	
	public List<Task> getTasksList() ;
	public List<Task> getTasksListByDepartment(String department);
	public List<Task> getTasksListByOwner(String taskOwner);
	public List<Task> getTasksListBySeverity(String serverityLevel);
	public List<Task> getTasksListByStatus(String taskStatus);
	public List<Task> getAgedTasksList(LocalDate date);
	public List<Meeting> getParticipantTotalHoursSpentInMeetings(String participant);
	public List<Meeting> getParticipantTotalHoursSpentInMeetingsByDepartment(String department);

}
