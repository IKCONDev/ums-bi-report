package com.ikn.ums.bi.report.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.ikn.ums.bi.report.model.Task;

public interface TaskService {

	public List<Task> getAgedTasksList(LocalDateTime date);
	
	public List<Task> getTasksListByStatus(String taskStatus);
	
	public List<Task> getTasksListBySeverity(String serverityLevel);
	
	public List<Task> getTasksListByOwner(String taskOwner);
	
	public List<Task> getTasksListByDepartment(Long departmentId);
	
	public List<Object[]> getAllDepartmentTasksCount();
	
	List<Long> getTasksListCount(@DateTimeFormat(iso =ISO.DATE_TIME) LocalDateTime startDate,@DateTimeFormat(iso =ISO.DATE_TIME)  LocalDateTime endDate);
	
	
}
