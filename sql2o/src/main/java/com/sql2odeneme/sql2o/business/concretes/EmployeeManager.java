package com.sql2odeneme.sql2o.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql2odeneme.sql2o.business.abstracts.EmployeeService;
import com.sql2odeneme.sql2o.dataAccess.abstracts.IEmployeeDao;
import com.sql2odeneme.sql2o.entities.Employee;


@Service
public class EmployeeManager implements EmployeeService {

	private IEmployeeDao  employeeDao;


	@Autowired
	public EmployeeManager(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public EmployeeManager() {}

	public List<Employee> getEmployeeList() {
	  return this.employeeDao.getAllEmployee();
		
	}

	public void addEmployee(Employee city) {
		
		employeeDao.insertEmployee(city);
		
	}

	public int getEmployeeCount() {
		return employeeDao.getEmployeeCount();
	}

}
