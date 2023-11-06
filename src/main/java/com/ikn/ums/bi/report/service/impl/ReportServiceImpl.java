package com.ikn.ums.bi.report.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.ikn.ums.bi.report.model.Meeting;
import com.ikn.ums.bi.report.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Override
	public List<Task> getTasksList() {
		return null;
	}

	@Override
	public List<Task> getTasksListByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksListByOwner(String taskOwner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksListBySeverity(String serverityLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksListByStatus(String taskStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAgedTasksList(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meeting> getParticipantTotalHoursSpentInMeetings(String participant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meeting> getParticipantTotalHoursSpentInMeetingsByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

}
