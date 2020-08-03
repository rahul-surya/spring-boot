package com.surya.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surya.springboot.demo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entitymanager) {
		
		this.entityManager = entitymanager;
	}

	@Override
	public List<Employee> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;

	}

	@Override
	public Employee save(Employee employee) {

		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);

		return employee;
		
	}

	@Override
	public String deleteById(int id) {

		Session session = entityManager.unwrap(Session.class);
		
		String result = null;
		
		Employee emp = findById(id);
		
		if(emp == null) {
			
			result = "Employee not found for id:"+id;
		}
		else {
			Query query = session.createQuery("delete from Employee where id=:empId");
		
			query.setParameter("empId", id);
		
			query.executeUpdate();
		
			result = "Employee deleted id:"+id;
		}
		
		return result;
	}

}
