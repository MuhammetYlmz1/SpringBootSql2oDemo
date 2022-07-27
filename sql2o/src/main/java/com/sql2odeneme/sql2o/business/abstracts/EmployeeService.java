package com.sql2odeneme.sql2o.business.abstracts;

import java.util.List;

import com.sql2odeneme.sql2o.entities.Employee;

public interface EmployeeService {
	List<Employee> getEmployeeList();
	void addEmployee(Employee employee);
	int getEmployeeCount();
	

}
