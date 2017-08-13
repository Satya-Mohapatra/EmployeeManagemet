package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeServiceImpl {
     List<Employee> getAllEmployees();
     Employee getEmployeeById(int eid);
     boolean addEmployee(Employee employee);
     void updateEmployee(Employee employee);
     void deleteEmployee(int eid);
}
