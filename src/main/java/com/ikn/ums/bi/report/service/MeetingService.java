package com.ikn.ums.bi.report.service;

import java.util.List;
import com.ikn.ums.bi.report.model.Meeting;

public interface MeetingService {
	
	public List<Meeting> getMeetingsByOrganizer(String organizer);
	public List<Meeting> getMeetingsByAttendee(String attendee);
	public List<Meeting> getMeetingsByDepartment(Long departmentId);
	public List<Meeting> getAllMeetings();
	//public List<DepartmentMeetingCount> getAllDepartmentMettingsCount();
	public List<Object[]> getAllDepartmentMettingsCount();
	//public List<Task> getAllTasksList();

}
