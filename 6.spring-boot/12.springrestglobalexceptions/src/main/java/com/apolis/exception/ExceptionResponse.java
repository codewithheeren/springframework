package com.apolis.exception;

import java.util.Date;

public class ExceptionResponse {
	private String message;
	private String code;
	private Date date;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public ExceptionResponse(String message, String code, Date date) {
		super();
		this.message = message;
		this.code = code;
		this.date = date;
	}

	public ExceptionResponse(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}

	public ExceptionResponse() {
		super();
	}

}
