package com.sql2odeneme.sql2o.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@NotBlank(message="Ad Kısmı Boş Bırakılamaz")
	@Size(min=2,message="Ad Kısmı En Az 2 Karakterden Oluşmalıdır")
	@Column(name="first_name")
	private String firstName;

	@NotEmpty
	@Column(name="last_name")
	private String lastName;
	
	@Email
	@NotEmpty
	@Column(name="email")
	private String email;
	
	@NotEmpty
	@Column(name="department")
	private String department;
	
	@NotNull
	@Column(name="salary")
	private int salary;
	


}
