package com.surya.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surya.springboot.demo.dao.EmployeeDAO;
import com.surya.springboot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO employeeDAO;
	
	//cons injection
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOHibernateImpl") EmployeeDAO employeeDAO) {
		
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
		
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {

		return employeeDAO.save(employee);
		
	}

	@Override
	@Transactional
	public String deleteById(int id) {

		return employeeDAO.deleteById(id);
		
	}

}
