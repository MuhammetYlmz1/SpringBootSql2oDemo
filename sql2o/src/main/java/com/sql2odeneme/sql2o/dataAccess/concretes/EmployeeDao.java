package com.sql2odeneme.sql2o.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.sql2odeneme.sql2o.dataAccess.abstracts.IEmployeeDao;
import com.sql2odeneme.sql2o.entities.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao {
	
	 private Sql2o sql2o;

	 public EmployeeDao() {
		 this.sql2o=new Sql2o("jdbc:mysql://localhost:3306/demo3", "root", "151859140");
		 
	 
	 }
	
	public List<Employee> getAllEmployee(){
		String sql="Select * from employee";
		
		List<Employee> array=new ArrayList<Employee>();
		
		Connection con=sql2o.open();
		
		array=con.createQuery(sql).executeAndFetch(Employee.class);
		
		return array;
		
	
	}
	public void insertEmployee(Employee employee) {
		String sql="insert into employee (first_name,last_name,email,department,salary) "+"values (:firstName,:lastName,:email,:department,:salary)";
		 
	
		try(Connection con=sql2o.beginTransaction()){
			con.createQuery(sql,true)
			
			.addParameter("firstName", employee.getFirstName())
			.addParameter("lastName", employee.getLastName())
			.addParameter("email",employee.getEmail())
			.addParameter("department", employee.getDepartment())
			.addParameter("salary", employee.getSalary())
			.executeUpdate();
			con.commit();
		}
			
			
	}
	
	
	
	public int getEmployeeCount() {
		String sql="Select count(id) from employee";
		Connection con=sql2o.open();
		return con.createQuery(sql).executeScalar(Integer.class);
		
	}

	@Override
	public Employee getById(int id) {
		 try( Connection con=sql2o.open()){
			final String query="Select * from employee where Id =:id";
			
			return  con.createQuery(query).addParameter("id", id).executeAndFetchFirst(Employee.class);
		 }
		
		
		
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		String query="Update employee set first_name=:firstName, last_name=:lastName, email=:email, department=:department, salary=:salary where Id=:id";

		try(Connection con=sql2o.open()){
			 con.createQuery(query)
			 .addParameter("firstName", employee.getFirstName())
				.addParameter("lastName", employee.getLastName())
				.addParameter("email",employee.getEmail())
				.addParameter("department", employee.getDepartment())
				.addParameter("salary", employee.getSalary())
				.addParameter("id", employee.getId())
				.executeUpdate();
			 return employee;
			 	
		}
		
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		String sqlQuery="Delete from employee where Id=:id";
		
		try(Connection con=sql2o.open()){
			con.createQuery(sqlQuery)
			.addParameter("id", id).executeUpdate();
		}
		
		
		
	}

	@Override
	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
		String query="Select * from employee where first_name like '%:firstName%' and last_name=:lastName";
		
		try(Connection con=sql2o.beginTransaction()){
			return con.createQuery(query)
			.addParameter("firstName", firstName)
			.addParameter("lastName", lastName)
			
			.executeAndFetch(Employee.class);
		}
		
		
		
	}


}
