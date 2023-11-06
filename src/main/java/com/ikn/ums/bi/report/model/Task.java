package com.ikn.ums.bi.report.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Task {

	private Integer taskId;
	private String taskTitle;
	private String taskDescription;
	private String taskPriority;
	private LocalDateTime startDate;
	private LocalDateTime dueDate;
	private String taskOwner;
	private String status;	
	private Integer actionItemId;
	private String emailId;
	private LocalDateTime createdDateTime;
	private LocalDateTime modifiedDateTime;
	private String createdBy;
	private String modifiedBy;
	private String createdByEmailId;
	private String modifiedByEmailId;
}
