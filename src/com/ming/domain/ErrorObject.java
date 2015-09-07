package com.ming.domain;

public class ErrorObject {
	private String message;
	
	public ErrorObject(){}
	
	public ErrorObject(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
