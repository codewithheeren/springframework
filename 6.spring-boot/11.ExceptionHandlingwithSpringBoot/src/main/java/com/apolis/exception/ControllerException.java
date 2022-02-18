package com.apolis.exception;

public class ControllerException extends RuntimeException {
	private String Code;
	private String message;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ControllerException(String code, String message) {
		super();
		Code = code;
		this.message = message;
	}
	public ControllerException() {
		super();
	}
	
}
