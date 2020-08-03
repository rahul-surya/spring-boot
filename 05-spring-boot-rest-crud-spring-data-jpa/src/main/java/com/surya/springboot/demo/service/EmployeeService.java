package com.surya.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import com.surya.springboot.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Optional<Employee> findById(int id);
	
	public Employee save(Employee employee);
	
	public int deleteById(int id);

}
