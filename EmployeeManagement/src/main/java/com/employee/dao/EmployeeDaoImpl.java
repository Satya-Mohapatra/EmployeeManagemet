package com.employee.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	@Override
	public Employee getEmployeeById(int eid) {
		return hibernateTemplate.get(Employee.class, eid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		String hql = "FROM Employee as e ORDER BY e.eid";
		return (List<Employee>) hibernateTemplate.find(hql);
	}	
	@Override
	public void addEmployee(Employee employee) {
		hibernateTemplate.save(employee);
	}
	@Override
	public void updateEmployee(Employee employee) {
		Employee p = getEmployeeById(employee.getEid());
		p.setEname(employee.getEname());
		p.setLocation(employee.getLocation());
		hibernateTemplate.update(p);
	}
	@Override
	public void deleteEmployee(int eid) {
		hibernateTemplate.delete(getEmployeeById(eid));
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean employeeExists(String ename, String mobileNumber, String emailAddress) {
		String hql = "FROM Employee as e WHERE e.ename = ? and e.mobileNumber = ? and e.emailAddress = ?";
		List<Employee> persons = (List<Employee>) hibernateTemplate.find(hql, ename, mobileNumber, emailAddress);
		return persons.size() > 0 ? true : false;
	}
}
