package com.surya.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
	
	@ExceptionHandler
	public  ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e){
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
				e.getMessage(),LocalDateTime.now());
		
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public  ResponseEntity<EmployeeErrorResponse> handleException(Exception e){
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(),
				e.getMessage(),LocalDateTime.now());
		
		return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
	}

}
