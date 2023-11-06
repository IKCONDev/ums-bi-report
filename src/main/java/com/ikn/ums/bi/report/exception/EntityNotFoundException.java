package com.ikn.ums.bi.report.exception;

import org.springframework.stereotype.Component;

@Component
public class EntityNotFoundException extends ReportsGlobalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String errorCode, String errorMessage) {
		super(errorCode , errorMessage );
	}
	
	public EntityNotFoundException() {
		
	}

}
