package com.employee.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.employee.entity.ErrorCode;

@ControllerAdvice
public class RestErrorHandler {
	
	@SuppressWarnings("unused")
	private MessageSource messageSource;
	
	@Autowired
	public RestErrorHandler (MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	@ExceptionHandler(EmployeeManagementException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleCustomException(Exception ex) {
		if (String.valueOf(ErrorCode.HTTP_400_INVALID_MOBILE_NO.getMessage()).equals(ex.getMessage())){
			return new ErrorResponse(ErrorCode.HTTP_400_INVALID_MOBILE_NO);			
		}
		else if (String.valueOf(ErrorCode.HTTP_400_INVALID_EMAIL_ID.getMessage()).equals(ex.getMessage())) {
			return new ErrorResponse(ErrorCode.HTTP_400_INVALID_EMAIL_ID);
		}
		else {
			return new ErrorResponse(ErrorCode.HTTP_500_INTERNAL_SERVER_ERROR);
		}
		
	}

}
