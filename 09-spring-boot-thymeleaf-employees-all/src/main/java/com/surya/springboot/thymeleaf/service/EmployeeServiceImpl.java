package com.surya.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.springboot.thymeleaf.dao.EmployeeRepository;
import com.surya.springboot.thymeleaf.entity.Employee;

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
		
//		return employeeRepository.findAll();
		
//      return employeeRepository.findByLastNameStartingWith("R");
		
		return employeeRepository.findAllByOrderByLastNameAsc();
		
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee emp = null;
		
		if(result.isPresent()) {
			
			emp = result.get();
		}
		else {
			throw new RuntimeException("Employee not found for id- "+id);
		}
		
		return emp;
	}

	@Override
	public Employee save(Employee employee) {

		return employeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(int id) {
		
		findById(id);
		
		employeeRepository.deleteById(id);
	}

}
