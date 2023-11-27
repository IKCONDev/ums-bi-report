package com.ikn.ums.bi.report.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Meeting {

	private Long meetingId;
	private String eventId;
	private String emailId;
	private String originalStartTimeZone;
	private String originalEndTimeZone;
	private String subject;
	private String type;
	private String occurrenceId;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private String startTimeZone;
	private String endTimeZone;
	private String location;
 //   private Set<Attendee> attendees;
    private String organizerEmailId;
    private String organizerName;
	private String onlineMeetingId;
	private String onlineMeetingProvider;

	private Long departmentId;
	private String seriesMasterId;
	private String joinUrl;
//	private List<Transcript> meetingTranscripts;
	private String insertedBy = "AUTO-BATCH-PROCESS";
    private String insertedDate = LocalDateTime.now().toString();
    private boolean isActionItemsGenerated = false;
    private boolean isManualMeeting = false;
    private Integer batchId;
	private String createdDateTime;
	private LocalDateTime modifiedDateTime;
	private String createdBy;
	private String modifiedBy;
	private String createdByEmailId;
	private String modifiedByEmailId;

}
