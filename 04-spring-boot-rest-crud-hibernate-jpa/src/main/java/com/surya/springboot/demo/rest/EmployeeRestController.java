package com.surya.springboot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surya.springboot.demo.entity.Employee;
import com.surya.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	EmployeeService employeeService;
	
	//cons injection
	@Autowired	
	public EmployeeRestController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee findById(@PathVariable int empId) {
		
		Employee emp = employeeService.findById(empId);
		
		if(emp == null) {
			throw new RuntimeException("Employee id not found : "+empId);
		}
		
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		
		//in case pass id in JSON request....set id to 0
		//this is to force a save of new item....instead of update
		
		emp.setId(0);
		
		return employeeService.save(emp);
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		return employeeService.save(emp);
		
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteById(@PathVariable int empId) {
		
		return employeeService.deleteById(empId);
	}
	
	

}
