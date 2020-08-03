package com.surya.springboot.demo.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.surya.springboot.demo.entity.Employee;
import com.surya.springboot.demo.exception.EmployeeNotFoundException;
import com.surya.springboot.demo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageSource;
	
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
	public EntityModel<Employee> findById(@PathVariable int empId) {
		
		Employee emp = employeeService.findById(empId).orElseThrow(() -> new EmployeeNotFoundException(messageSource.getMessage("error.notfound", null, LocaleContextHolder.getLocale()) + empId)); 
		
		//HATEOAS(Hypertext as the Engine of Application State)
		
		@SuppressWarnings("deprecation")
		EntityModel<Employee> model = new EntityModel<>(emp);
		
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeRestController.class).findAll());
		
		model.add(linkTo.withRel("all-employees"));
		
		return model;
		
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee emp) {
		
		//in case pass id in JSON request....set id to 0
		//this is to force a save of new item....instead of update
		
		emp.setId(0);
		
		Employee savedEmp = employeeService.save(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedEmp.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		return employeeService.save(emp);
		
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteById(@PathVariable int empId) {
		
		int val = employeeService.deleteById(empId);
		
		if(val > 0)
		   return  "Employee deleted id:"+empId;
		else {
			return "Employee not found for id - " + empId;
		}
	}

}
