package com.sql2odeneme.sql2o.dataAccess.abstracts;

import java.util.List;

import com.sql2odeneme.sql2o.entities.Employee;

public interface IEmployeeDao {
	
	List<Employee> getAllEmployee();
	void insertEmployee(Employee city);
	int getEmployeeCount();
	Employee getById(int id);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(int id);
	List<Employee> findByFirstNameAndLastName(String firstName,String lastName);
	
 
}
