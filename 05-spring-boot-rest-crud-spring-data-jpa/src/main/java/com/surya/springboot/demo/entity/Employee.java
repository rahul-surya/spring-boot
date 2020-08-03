package com.surya.springboot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "employee")
//swagger
@ApiModel(description = "Details about the employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@Size(min = 2, message = "First Name should be atleast 2 characters")
	@ApiModelProperty(notes = "First Name should be atleast 2 characters")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	@Pattern(regexp  = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",message = "Email addres is not valid")
	private String email;
	
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	/*
	 * CREATE TABLE `employee` ( `id` int(11) NOT NULL AUTO_INCREMENT, `first_name`
	 * varchar(45) DEFAULT NULL, `last_name` varchar(45) DEFAULT NULL, `email`
	 * varchar(45) DEFAULT NULL, PRIMARY KEY (`id`) ) ENGINE=InnoDB
	 * AUTO_INCREMENT=13 DEFAULT CHARSET=latin1
	 */
	

}
