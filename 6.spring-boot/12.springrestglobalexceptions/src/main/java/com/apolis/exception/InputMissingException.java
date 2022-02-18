package com.apolis.exception;

public class InputMissingException extends RuntimeException{
	private String msg;
	private String code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public InputMissingException(String msg, String code) {
		super();
		this.msg = msg;
		this.code = code;
	}

	public InputMissingException() {
		super();
	}

}
