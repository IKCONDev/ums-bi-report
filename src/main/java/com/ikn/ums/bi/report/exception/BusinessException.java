package com.ikn.ums.bi.report.exception;

public class BusinessException extends ReportsGlobalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String errorCode, String errorMessage) {
		super(errorCode , errorMessage );
	}
	
	public BusinessException() {
	}
}
