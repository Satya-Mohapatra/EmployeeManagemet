package com.employee.dao;
import java.util.List;

import com.employee.entity.Employee;
public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int eid);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int eid);
    boolean employeeExists(String ename, String mobileNumber, String emailAddress);
}
 