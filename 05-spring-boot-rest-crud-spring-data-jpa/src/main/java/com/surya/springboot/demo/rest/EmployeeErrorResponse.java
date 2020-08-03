package com.surya.springboot.demo.rest;

import java.time.LocalDateTime;

public class EmployeeErrorResponse {
	
	private int status;
	private String error;
	private LocalDateTime timestamp;
	
	
	
	
	public EmployeeErrorResponse() {
		
	}


	public EmployeeErrorResponse(int status, String error, LocalDateTime timestamp) {
		this.status = status;
		this.error = error;
		this.timestamp = timestamp;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	

}
