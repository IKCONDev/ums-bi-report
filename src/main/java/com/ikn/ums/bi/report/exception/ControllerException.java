package com.ikn.ums.bi.report.exception;

public class ControllerException extends ReportsGlobalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerException(String errorCode, String errorMessage) {
		super(errorCode , errorMessage );
	}
	
	public ControllerException() {
		
	}	
}
