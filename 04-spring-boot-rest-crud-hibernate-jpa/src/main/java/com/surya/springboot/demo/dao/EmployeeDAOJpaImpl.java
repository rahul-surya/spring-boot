package com.surya.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surya.springboot.demo.entity.Employee;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entitymanager) {
		
		this.entityManager = entitymanager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		
		Employee emp = entityManager.merge(employee);
		
		employee.setId(emp.getId());
		
		return employee;
	}

	@Override
	public String deleteById(int id) {
String result = null;
		
		Employee emp = findById(id);
		
		if(emp == null) {
			
			result = "Employee not found for id:"+id;
		}
		else {
			Query query = entityManager.createQuery("delete from Employee where id=:empId");
		
			query.setParameter("empId", id);
		
			query.executeUpdate();
		
			result = "Employee deleted id:"+id;
		}
		
		return result;
	}

}
