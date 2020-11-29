package com.todo1.api.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductException extends Exception{
	private static final long serialVersionUID = 1L;
	private String description;
	
    public ProductException(Exception exception, String message) {
		super(exception);
		this.description = message;
	}
    
	@Override
    public String getMessage(){
    	return description;
    }
}
