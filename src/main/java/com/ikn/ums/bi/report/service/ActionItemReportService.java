package com.ikn.ums.bi.report.service;

import java.util.List;

import com.ikn.ums.bi.report.model.ActionItem;

public interface ActionItemReportService {
	
	List<ActionItem> getActionItemsByOrganizer(String organizer);
	List<ActionItem> getActionItemsByDepartment(Long departmentId);
	List<ActionItem> getActionItemsByPriority(String priority);

}
