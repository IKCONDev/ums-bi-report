package com.ikn.ums.bi.report.service;

import java.util.List;

import com.ikn.ums.bi.report.model.Task;

public interface TaskCategoryService {
	
	public List<Task> getAllTasksByCategoryId(Long taskCategoryId);
	
	public List<Object[]> getAllTaskCategoryCount();

}
