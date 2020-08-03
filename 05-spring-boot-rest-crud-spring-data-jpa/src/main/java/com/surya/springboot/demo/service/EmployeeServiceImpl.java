package com.surya.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.springboot.demo.dao.EmployeeRepository;
import com.surya.springboot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	
	//cons injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		
		return employeeRepository.findById(id);
		
//		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found for id- "+id));
		
		//Optional<Employee> result = employeeRepository.findById(id);
		
//		Employee emp = null;
//		
//		if(result.isPresent()) {
//			
//			emp = result.get();
//		}
//		else {
//			throw new EmployeeNotFoundException("Employee not found for id- "+id);
//		}
//		
//		return emp;
	
	}

	@Override
	public Employee save(Employee employee) {

		return employeeRepository.save(employee);
		
	}

	@Override
	public int deleteById(int id) {
		
		Optional<Employee> result =  findById(id);
		
		int val = -1 ;
		
		if(result.isPresent()) {
			
			employeeRepository.deleteById(id);
			
			val = 1;
		}	
		
		return val;
	}

}
