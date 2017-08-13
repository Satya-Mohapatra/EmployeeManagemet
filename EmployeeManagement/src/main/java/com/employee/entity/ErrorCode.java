package com.employee.entity;

/**
 * ErrorCode is used to select the status code and error message
 * @author SATYA
 *
 */
public enum ErrorCode {
	HTTP_400_INVALID_MOBILE_NO(400,"Please Enter a Valid Mobile Number"),
	HTTP_400_INVALID_EMAIL_ID(400,"Please Provide a Valid Email id"),
	HTTP_500_INTERNAL_SERVER_ERROR(500, "internal server error");
	
	private int code;
	private String message;
	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
