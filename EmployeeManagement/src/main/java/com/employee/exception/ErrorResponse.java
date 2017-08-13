package com.employee.exception;

import com.employee.entity.ErrorCode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
	@JsonProperty(value="error-code", required = true)
	private int errorCode;
	
	@JsonProperty(value="error-message", required = true)
	private String errorMessage;

	public ErrorResponse(ErrorCode errorCode) {
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
