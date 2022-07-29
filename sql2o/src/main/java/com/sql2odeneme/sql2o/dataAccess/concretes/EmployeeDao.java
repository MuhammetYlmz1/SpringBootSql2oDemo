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
		
	/*	for (City city : array) {
			System.out.println(city.getId()+" "+city.getName()+" "+city.getCountryCode()+" "+city.getDistrict()+" "+city.getPopulation() );
		}*/
		
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


}
