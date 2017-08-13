package com.employee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eid")
	private int eid;
	
	@Column(name = "ename")
	@NotNull
	private String ename;
	
	@Column(name = "mobile_no")
	@NotNull
	private String mobileNumber;
	
	@Column(name = "email_address")
	@NotNull
	@Email(message="Please provide a valid email address")
	private String emailAddress;
	
	@Column(name= "date_of_birth")
	@NotNull
	private Date dateOfBirth;
	
	@Column(name = "date_of_employment")
	@NotNull
	private Date dateOfEmployment;
	
	@Column(name = "location")
	@NotNull
	private String location;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}