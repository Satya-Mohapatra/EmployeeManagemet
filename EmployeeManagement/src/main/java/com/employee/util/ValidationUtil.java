package com.employee.util;

import com.employee.entity.ErrorCode;
import com.employee.exception.EmployeeManagementException;

/**
 * ValidationUtil - Used to validate Mobile no and Email id
 * @author SATYA
 *
 */
public class ValidationUtil {
	/**
	 * Method to validate Mobile No
	 * @param mobileNumber
	 * @return
	 */
	public static boolean isValidMobileNumber(String mobileNumber) {
		boolean isValid = true;
		if (mobileNumber.matches("^[0-9]{10}$")) {
			return isValid;
		} else {
			throw new EmployeeManagementException(
					ErrorCode.HTTP_400_INVALID_MOBILE_NO.getMessage());
		}
	}

	/**
	 * Method to validate EmailId
	 * @param emailId
	 * @return
	 */
	public static boolean isValidEmailAddress(String emailId) {
		boolean isValid = true;
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (emailId.matches(EMAIL_PATTERN)) {
			return isValid;
		} else {
			throw new EmployeeManagementException(
					ErrorCode.HTTP_400_INVALID_EMAIL_ID.getMessage());
		}
	}
}
