package com.surya.springboot.demo.service;

import java.util.List;

import com.surya.springboot.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee);
	
	public String deleteById(int id);

}
