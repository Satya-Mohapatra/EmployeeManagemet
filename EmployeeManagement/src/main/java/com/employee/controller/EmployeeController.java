package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.employee.entity.Employee;
import com.employee.service.EmployeeServiceImpl;
import com.employee.util.ValidationUtil;

/**
 * Employee Controller Class
 * 
 * @author SATYA
 * 
 */
@Controller
@RequestMapping("/info")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping("/home")
	public String home() {
		return "employee";
	}

	/**
	 * Method to get Employee details by Id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(
			@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/**
	 * Method to get all Employee details
	 * @return
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	/**
	 * Method to add Employee details
	 * @param employee
	 * @param builder
	 * @return
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee,
			UriComponentsBuilder builder) {
		ValidationUtil.isValidMobileNumber(employee.getMobileNumber());
		ValidationUtil.isValidEmailAddress(employee.getEmailAddress());
		boolean flag = employeeService.addEmployee(employee);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employee/{id}")
				.buildAndExpand(employee.getEid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Method to update Employee details
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(
			@RequestBody Employee employee) {
		ValidationUtil.isValidMobileNumber(employee.getMobileNumber());
		ValidationUtil.isValidEmailAddress(employee.getEmailAddress());
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/**
	 * Method to delete an Employee
	 * @param eid
	 * @return
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer eid) {
		employeeService.deleteEmployee(eid);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}