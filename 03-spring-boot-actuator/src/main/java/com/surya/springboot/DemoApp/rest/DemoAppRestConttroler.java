package com.surya.springboot.DemoApp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAppRestConttroler {
	
	@GetMapping("/")
	public String helloMessage() {
		
		return "Hello " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getWorkout() {
		
		return "Run daily 5km.";
	}

}
