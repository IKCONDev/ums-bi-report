package com.ikn.ums.bi.report.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActionItem {
	
	private Integer actionItemId;
	private Long meetingId;
	private String emailId;
	private List<String> actionItemOwner;
	private String actionItemTitle;
	private String actionItemDescription;
	private String actionPriority;
	private String actionStatus = "Not Submitted";
	private Long departmentId;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDateTime createdDateTime;
	private LocalDateTime modifiedDateTime;
	private String createdBy;
	private String modifiedBy;
	private String createdByEmailId;
	private String modifiedByEmailId;

}
