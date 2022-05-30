package com.nasa.nalog.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyResourceNotFoundException(String message) {
		super(message);
	}

}
