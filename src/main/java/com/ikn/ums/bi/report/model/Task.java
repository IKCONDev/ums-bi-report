package com.ikn.ums.bi.report.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Task {

	private Integer taskId;
	private String taskTitle;
	private String taskDescription;
	private String taskPriority;
	private LocalDate startDate;
	private LocalDate dueDate;
	private String taskOwner;
	private String status;	
	private Integer actionItemId;
	private String emailId;
	private Long departmentId;
	private LocalDateTime createdDateTime;
	private LocalDateTime modifiedDateTime;
	private String createdBy;
	private String modifiedBy;
	private String createdByEmailId;
	private String modifiedByEmailId;
}
