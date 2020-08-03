package com.surya.springboot.demo.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public  ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e, WebRequest request) {
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
				e.getMessage(),request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String,Object> body = new LinkedHashMap<>();
		
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("timestamp", LocalDateTime.now());
		
//		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//	        errors.add(error.getField() + ": " + error.getDefaultMessage());
//	    }
		
		
		List<String> listErrors = e.getBindingResult().getAllErrors().stream().map( err -> err.getDefaultMessage()).collect(Collectors.toList());
		
		body.put("errors", listErrors);
		
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<Object> handleAllExceptiona(Exception e, WebRequest request){
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(),request.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}


	
	
	
	
	
	
	
	

}
