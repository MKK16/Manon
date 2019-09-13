package com.target.pm.exception;

import org.springframework.http.HttpStatus;

public class ProductManagementException extends RuntimeException {

	private static final long serialVersionUID = 92915688781968587L;
	
	HttpStatus httpStatus;
	
	public ProductManagementException(String message,HttpStatus httpStatus) {
		super(message);
		this.httpStatus=httpStatus;
	}
	
	public ProductManagementException(String message, Throwable cause,HttpStatus httpStatus) {
		super(message);
		this.httpStatus=httpStatus;
	}
	
}
