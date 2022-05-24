package com.sah.app.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	private int fieldAge;
	
	public resourceNotFoundException(String resourceName, String fieldName, Object fieldValue, int fieldAge) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue, fieldAge));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.fieldAge = fieldAge;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
	
	public int getFieldAge() {
		return fieldAge;
	}
	
}