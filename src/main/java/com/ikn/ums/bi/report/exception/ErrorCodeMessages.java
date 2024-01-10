package com.ikn.ums.bi.report.exception;

public class ErrorCodeMessages {
	
	//REPORT MODULE ERROR CODES

	 public static final String ERR_REPORT_SERVICE_NOT_FOUND_CODE = "REPORT-CORE-SERVICE-1001";
	 public static final String ERR_REPORT_SERVICE_NOT_FOUND_MSG = "Report Service not present.";
	 
	 public static final String ERR_REPORT_ENTITY_IS_NULL_CODE = "REPORT-ENTITY-IS-NULL-1002";
	 public static final String ERR_REPORT_ENTITY_IS_NULL_MSG = "Report Entity is Null."; 
	 
	 public static final String ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_CODE = "ERR_REPORT_ACTIONITEM_ENTITY_IS_NULL_CODE-1003";
	 public static final String ERR_REPORT_ACTIONITEM_LIST_ENTITY_IS_NULL_MSG = "Action Item Entity is Null"; 
	 
	 public static final String ERR_REPORT_TASK_LIST_ENTITY_IS_NULL_CODE = "ERR_REPORT_ACTIONITEM_ENTITY_IS_NULL_CODE-1004";
	 public static final String ERR_REPORT_TASK_LIST_ENTITY_IS_NULL_MSG = "Task Entity is Null"; 
	 
	 public static final String ERR_REPORT_DEPARTMENTID_IS_NULL_CODE = "ERR_REPORT_DEPARTMENTID_IS_NULL_CODE-1005";
	 public static final String ERR_REPORT_DEPARTMENTID_IS_NULL_MSG = "Department ID is Null"; 
	 
	 
	 public static final String ERR_REPORT_EMAILID_IS_NULL_CODE = "ERR_REPORT_EMAILID_IS_NULL_CODE-1006";
	 public static final String ERR_REPORT_EMAILID_IS_NULL_MSG = "Email ID is Null";

	 public static final String ERR_REPORT_PRIORITY_IS_NULL_CODE = "ERR_REPORT_PRIORITY_IS_NULL_CODE-1007";
	 public static final String ERR_REPORT_PRIORITY_IS_NULL_MSG = "Priority is Null";
	 
	 public static final String ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_CODE = "ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_CODE-1008";
	 public static final String ERR_REPORT_DRPARTMENT_COUNT_IS_NULL_MSG = "Department Count is Null";
	 
	 public static final String ERR_REPORT_DATE_IS_NULL_CODE = "ERR_REPORT_DATE_IS_NULL_CODE-1009";
	 public static final String ERR_REPORT_DATE_IS_NULL_MSG = "Date is Null";
	 
	 public static final String ERR_REPORT_SEVERITY_IS_NULL_CODE = "ERR_REPORT_PRIORITY_IS_NULL_CODE-1010";
	 public static final String ERR_REPORT_SEVERITY_IS_NULL_MSG = "Severity is Null";
	 
	 public static final String ERR_REPORT_TASKOWNER_IS_NULL_CODE = "ERR_REPORT_TASKOWNER_IS_NULL_CODE-1011";
	 public static final String ERR_REPORT_TASKOWNER_IS_NULL_MSG = "task owner is Null";
	 
	 public static final String ERR_REPORT_STATUS_IS_NULL_CODE = "ERR_REPORT_STATUS_IS_NULL_CODE-1012";
	 public static final String ERR_REPORT_STATUS_IS_NULL_MSG = "status is Null";
	 
	 public static final String ERR_REPORT_MEETINGS_LIST_ENTITY_IS_NULL_CODE = "ERR_REPORT_MEETINGS_LIST_ENTITY_IS_NULL_CODE-1013";
	 public static final String ERR_REPORT_MEETINGS_LIST_ENTITY_IS_NULL_MSG = "Meeting List Entity is Null"; 
	 
	 public static final String ERR_REPORT_TASKCATEGORY_ID_IS_NULL_CODE = "ERR_REPORT_TASKCATEGORY_ID_IS_NULL_CODE-1014";
	 public static final String ERR_REPORT_TASKCATEGORY_ID_IS_NULL_MSG = "Email ID is Null";
	 
	 
	 public static final String ERR_REPORT_GET_MEETINGS_UNSUCCESS_CODE = "ERR_GET_MEETINGS_UNSUCCESS_CODE-1009";
	 public static final String ERR_REPORT_GET_MEETINGS_UNSUCCESS_MSG = "Exception occured while fetching meetings";
	 
     public static final String ERR_REPORT_GET_ACTIONITEMS_UNSUCCESS_CODE = "ERR_GET_ACTIONITEMS_UNSUCCESS_CODE-1009";
     public static final String ERR_REPORT_GET_ACTIONITEMS_UNSUCCESS_MSG = "Exception occured while fetching actionItems";
 
     public static final String ERR_REPORT_GET_TASKS_UNSUCCESS_CODE = "ERR_GET_TASKS_UNSUCCESS_CODE-1009";
     public static final String ERR_REPORT_GET_TASKS_UNSUCCESS_MSG = "Exception occured while fetching Tasks";
	 
//REPORT TASKS MODULE ERROR CODES



//	 public static final String ERR_ROLE_NAME_IS_EMPTY_CODE = "ROLE_NAME_IS_EMPTY-1006";
//	 public static final String ERR_ROLE_NAME_IS_EMPTY_MSG = "Role Name Is Empty."; 	
//	 
//	 public static final String ERR_ROLE_ENTITY_IS_NULL_CODE = "ROLE-ENTITY-IS-NULL-1007";
//	 public static final String ERR_ROLE_ENTITY_IS_NULL_MSG = "Role Entity is Null."; 
//	 
//	 public static final String ERR_ROLE_SERVICE_EXCEPTION_CODE = "ROLE_SERVICE_EXCEPTION_CODE-1007";
//	 public static final String ERR_ROLE_SERVICE_EXCEPTION_MSG = "Exception Occured in the Role Service Layer."; 
	 
//	 public static final String ERR_ROLE_DELETE_UNSUCCESS_CODE = "ROLE_DELETE_UNSUCCESS_CODE-1010";
//	 public static final String ERR_ROLE_DELETE_UNSUCCESS_MSG = "Exception occured while deleting role";
//	 
//	 public static final String ERR_ROLE_UPDATE_UNSUCCESS_CODE = "ROLE_UPDATE_UNSUCCESS_CODE-1011";
//	 public static final String ERR_ROLE_UPDATE_UNSUCCESS_MSG = "Exception occured while updating role";
//
//	 public static final String ERR_ROLE_NAME_EXISTS_CODE = "ROLE_NAME_EXISTS_CODE-1011";
//	 public static final String ERR_ROLE_NAME_EXISTS_MSG = "Role Name Already Exists";
//	 
//	 public static final String ERR_ROLE_GET_UNSUCCESS_CODE = "ERR_ROLE_GET_UNSUCCESS_CODE-1012";
//	 public static final String ERR_ROLE_GET_UNSUCCESS_MSG = "Error while getting user role(s)";
	 
	 //REPORT MEETING MODULE ERROR CODES
	 
//	 public static final String ERR_ORG_ENTITY_IS_NULL_CODE = "ORG-ENTITY-IS-NULL-1027";
//	 public static final String ERR_ORG_ENTITY_IS_NULL_MSG = "Organization Entity is Null."; 
//
//	 public static final String ERR_ORG_ID_NOT_FOUND_CODE = "ORG-ID-NOT-FOUND-1028";
//	 public static final String ERR_ORG_ID_NOT_FOUND_MSG = "Requested Organization Id is not present."; 
//
//	 public static final String ERR_ORG_ID_ALREADY_EXISTS_CODE = "ORG-ID-ALREADY-EXISTS-1029";
//	 public static final String ERR_ORG_ID_ALREADY_EXISTS_MSG = "Organization Id Already Exists."; 
//
//	 public static final String ERR_ORG_FIRST_NAME_IS_NULL_CODE = "ORG_FIRST_NAME_IS_NULL-1030";
//	 public static final String ERR_ORG_FIRST_NAME_IS_NULL_MSG = "Organization First Name Is Null."; 
//
//	 public static final String ERR_ORG_LAST_NAME_IS_NULL_CODE = "ORG_LAST_NAME_IS_NULL-1031";
//	 public static final String ERR_ORG_LAST_NAME_IS_NULL_MSG = "Organization Last Name Is Null."; 
//	 
//	 public static final String ORG_SAVE_UNSUCCESS_CODE = "Organization-SAVE-UNSUCCESS-1032";
//	 public static final String ORG_SAVE_UNSUCCESS_MSG = "Exception occured while saving Organization."; 	 
//	 
//	 public static final String ERR_ORG_LIST_IS_ENTITY_CODE = "ORG_LIST_IS_ENTITY-1033";
//	 public static final String ERR_ORG_LIST_IS_ENTITY_MSG = "Organization List Is Empty."; 	 
//
//	 public static final String ERR_ORG_SERVICE_EXCEPTION_CODE = "ORG_SERVICE_EXCEPTION_CODE-1034";
//	 public static final String ERR_ORG_SERVICE_EXCEPTION_MSG = "Organization Occured in the Employee Service Layer."; 	
//
//	 public static final String ERR_ORG_EMAIL_ID_NOT_FOUND_CODE = "ORG_EMAIL_ID_NOT_FOUND_CODE-1035";
//	 public static final String ERR_ORG_EMAIL_ID_NOT_FOUND_MSG = "Organization Email Id is not found."; 	
//
//	 public static final String ERR_ORG_LIST_IS_EMPTY_CODE = "ORG_LIST_IS_EMPTY-1036";
//	 public static final String ERR_ORG_LIST_IS_EMPTY_MSG = "Organization List Is Empty."; 	 
//
//	 public static final String ERR_ORG_ID_IS_EMPTY_CODE = "ORG-ID-IS-EMPTY-1037";
//	 public static final String ERR_ORG_ID_IS_EMPTY_MSG = "Requested Organization Id is not present."; 
//
//	 public static final String ERR_ORG_CONTROLLER_EXCEPTION_CODE = "ORG_CONTROLLER_EXCEPTION-1038";
//	 public static final String ERR_ORG_CONTROLLER_EXCEPTION_MSG = "Organization Controller Exception Occurred."; 
//	 
//	 public static final String ERR_ORG_UPDATE_UNSUCCESS_CODE = "ORG_UPDATE_UNSUCCESS_CODE-1039";
//	 public static final String ERR_ORG_UPDATE_UNSUCCESS_MSG = "Exception Occured while Updating Organization."; 
//	 
//	 public static final String ERR_ORG_DELETE_UNSUCCESS_CODE = "ORG_DELETE_UNSUCCESS_CODE-1040";
//	 public static final String ERR_ORG_DELETE_UNSUCCESS_MSG = "Exception Occured while deleting Organization."; 
//	 
//	 public static final String ERR_ORG_GET_UNSUCCESS_CODE = "ERR_ORG_GET_UNSUCCESS_CODE-1041";
//	 public static final String ERR_ORG_GET_UNSUCCESS_MSG = "Exception Occured while getting Organization details."; 
//	 
//	 public static final String ERR_USER_IMAGE_NOT_VALID_CODE = "IMAGE-IS-NOT-VALID-1042";
//	 public static final String ERR_USER_IMAGE_NOT_VALID_MSG = "THIS IS NOT A VALID IMAGE FILE";
//	 
//	 public static final String ERR_USER_NOT_FOUND_CODE = "ERR_USER_NOT_FOUND_CODE-1043";
//	 public static final String ERR_USER_NOT_FOUND_MSG = "User does not exists to Login";
//	 
//	 public static final String ERR_USER_INACTIVE_CODE = "ERR_USER_INACTIVE_CODE-1043";
//	 public static final String ERR_USER_INACTIVE_MSG = "User is inactive - Cannot Login";
	 
}
