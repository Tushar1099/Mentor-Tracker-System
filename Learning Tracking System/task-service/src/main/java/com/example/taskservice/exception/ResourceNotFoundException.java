package com.example.taskservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private int fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, int taskId) {
		super(String.format("%s not found with %s : '%s' ", resourceName,fieldName,taskId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = taskId;
	}
}

