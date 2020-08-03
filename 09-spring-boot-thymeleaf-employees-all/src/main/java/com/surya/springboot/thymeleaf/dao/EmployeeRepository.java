package com.surya.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.springboot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//sort by last name asc
	public List<Employee> findAllByOrderByLastNameAsc();
	
	public List<Employee> findByLastNameStartingWith(String prefix);

}
