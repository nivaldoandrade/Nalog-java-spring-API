package com.nasa.nalog.domain.exception;

public class MyResourceBadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyResourceBadRequestException(String message) {
		super(message);
	}

}
