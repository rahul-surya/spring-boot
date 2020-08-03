package com.surya.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surya.springboot.thymeleaf.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> empList;
	
	@PostConstruct
	public void loadData() {
		
		empList = new ArrayList<Employee>();
		
		empList.add(new Employee(1,"Kapil","Sharma","k.sharma@gmail.com"));
		empList.add(new Employee(2,"Virat","Kohli","virat@gmail.com"));
		empList.add(new Employee(3,"Sachin","JIgar","sachin@gmail.com"));
		
	}
	
	
	
	@GetMapping("/list")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("employees",empList);
		
		return "list-employee";
	}

}
