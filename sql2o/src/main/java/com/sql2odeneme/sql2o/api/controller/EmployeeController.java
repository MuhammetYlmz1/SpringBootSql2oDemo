package com.sql2odeneme.sql2o.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		 return new ResponseEntity<String>("Çalışan Eklendi",HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/getEmployeeCount")
	public int getEmployeeCount() {
		return employeeService.getEmployeeCount();
		
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable int id) {
		return employeeService.getById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@Valid @RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		return new ResponseEntity<String>("Bilgiler Güncellendi",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Kullanıcı Silindi");

	}
	
	@GetMapping("/getFirstNameAndLastName")
	public ResponseEntity<?> findByFirstNameAndLastName(@Valid @RequestParam String firstName,@Valid @RequestParam String lastName){
		List<Employee> employees= employeeService.findByFirstNameAndLastName(firstName, lastName);
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.ACCEPTED);
	}
	
}
