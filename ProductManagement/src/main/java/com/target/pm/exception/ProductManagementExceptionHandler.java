package com.target.pm.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.target.pm.model.ErrorResponse;

@RestControllerAdvice
public class ProductManagementExceptionHandler  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ProductManagementException.class })
	protected ResponseEntity<ErrorResponse> handleRuntimeException(ProductManagementException exception) {
		       return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getClass().getName(),exception.getMessage()),exception.httpStatus);
		    }
}
