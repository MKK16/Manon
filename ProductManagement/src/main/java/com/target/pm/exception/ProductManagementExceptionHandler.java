package com.target.pm.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.target.pm.model.ErrorResponse;

@RestControllerAdvice
public class ProductManagementExceptionHandler  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ProductManagementException.class })
	protected ResponseEntity<ErrorResponse> handleRuntimeException(ProductManagementException exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getClass().getName(),exception.getMessage()),exception.httpStatus);
    }
	
	@ExceptionHandler(value = {Exception.class })
	protected ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
	    return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getClass().getName(),exception.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,HttpHeaders headers,HttpStatus status,WebRequest request) {
        return handleExceptionInternal(exception,new ErrorResponse("INVALID_INPUT",exception.getBindingResult().getFieldError().getDefaultMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
}
