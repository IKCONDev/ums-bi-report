package com.ikn.ums.bi.report.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handling the Controller Exceptions global to reduce boiler plate code
	 * @param noSuchElementException
	 * @return
	 */
	@ExceptionHandler(ControllerException.class)
	public ResponseEntity<String> handleControllerException(ControllerException controllerException) {
		log.info("GlobalExceptionHandler.handleControllerException() ENTERED");
		log.info("Controller Exception Occurred ::::::::::::: " + controllerException.getErrorCode());
		log.info("Controller Exception Occurred ::::::::::::: " + controllerException.getErrorMessage());
		return new ResponseEntity<String>("Controller Exception.", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handling the Business Exceptions global to reduce boiler plate code
	 * @param noSuchElementException
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusinessException(BusinessException businessException) {
		log.info("GlobalExceptionHandler.handleBusinessException() ENTERED");
		log.info("Business Exception Occurred." + businessException.getMessage());
		return new ResponseEntity<String>("Business Exception.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * EntityNotFoundException handles the exception when the Object is NUll
	 * @param emptyInputException
	 * @return
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
		log.info("GlobalExceptionHandler.handleEntityNotFoundException() ENTERED" );
		log.info("EntityNotFoundException Occurred ::::::::::::: " + entityNotFoundException.getErrorCode());
		log.info("EntityNotFoundException Occurred ::::::::::::: " + entityNotFoundException.getErrorMessage());
		
		return new ResponseEntity<String>("Entity Object is NUll.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * The NoSuchElementException is a Pre-defined default handler for the
	 * SpringBoot. No class required to be created for pre-defined.
	 * 
	 * @param noSuchElementException
	 * @return
	 */
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		log.info("GlobalExceptionHandler.handleNoSuchElementException() ENTERED" + noSuchElementException.getMessage());
		return new ResponseEntity<String>("No Value is Present in DB.", HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("GlobalExceptionHandler.handleEmptyInput() ENTERED " + ex.getMessage());
		return new ResponseEntity<Object>("Please change your http method type.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException) {
		log.info("GlobalExceptionHandler.handleNoSuchElementException() ENTERED" + emptyInputException.getMessage());
		return new ResponseEntity<String>("Input field is empty. Please look into it.", HttpStatus.BAD_REQUEST);
	}

}
