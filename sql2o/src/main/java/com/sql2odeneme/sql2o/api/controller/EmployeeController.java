package com.sql2odeneme.sql2o.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sql2odeneme.sql2o.business.abstracts.EmployeeService;
import com.sql2odeneme.sql2o.entities.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController  implements WebMvcConfigurer{
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll() {
		return employeeService.getEmployeeList();
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);		
		 return ResponseEntity.ok("User is valid");
		
	}
	@GetMapping("/getEmployeeCount")
	public int getEmployeeCount() {
		return employeeService.getEmployeeCount();
		
	}
	
	
}
