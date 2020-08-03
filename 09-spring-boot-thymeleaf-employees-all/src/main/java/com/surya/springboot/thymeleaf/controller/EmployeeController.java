package com.surya.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.surya.springboot.thymeleaf.entity.Employee;
import com.surya.springboot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	//Since only one constructor, @Autowired is optional
	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/list")
	public String findAll(Model theModel) {
		
		List<Employee> empList = employeeService.findAll();
		
		theModel.addAttribute("employees", empList);
		
		return "employees/list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		Employee employee = new Employee();
		
		theModel.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int empId,Model theModel){
		
		Employee employee = employeeService.findById(empId);
		
		theModel.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {	
		
		employeeService.save(employee);
		
		//use to redirect to prevent multiple submission
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("employeeId") int empId,Model theModel){	
		
		employeeService.deleteById(empId);
		
		//use to redirect to prevent multiple submission
		
		return "redirect:/employees/list";
	}

}
