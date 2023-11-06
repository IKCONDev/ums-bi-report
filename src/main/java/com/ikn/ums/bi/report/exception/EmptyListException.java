package com.ikn.ums.bi.report.exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyListException extends ReportsGlobalException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyListException(String errorCode, String errorMessage) {
		super(errorCode , errorMessage );
	}
	
	public EmptyListException() {
		
	}
}
