package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

/**service class **/
@Service
public class EmployeeService implements EmployeeServiceImpl {
	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public Employee getEmployeeById(int eid) {
		Employee obj = employeeDao.getEmployeeById(eid);
		return obj;
	}	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	@Override
	public synchronized boolean addEmployee(Employee employee){
       if (employeeDao.employeeExists(employee.getEname(), employee.getMobileNumber(),  employee.getEmailAddress())) {
    	   return false;
       } else {
    	   employeeDao.addEmployee(employee);
    	   return true;
       }
	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	@Override
	public void deleteEmployee(int eid) {
		employeeDao.deleteEmployee(eid);
	}
}
