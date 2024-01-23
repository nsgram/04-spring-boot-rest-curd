package com.capgemini.demo.exceptions;

public class StudentNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public StudentNotFound(String message, Throwable cause) {
		super(message, cause);
		
	}

	public StudentNotFound(String message) {
		super(message);
		
	}
  
}
