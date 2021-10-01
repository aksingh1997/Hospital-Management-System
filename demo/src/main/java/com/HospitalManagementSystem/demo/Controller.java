package com.HospitalManagementSystem.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.HospitalManagementSystem.Entity.Disease;

@RestController
public class Controller {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ABC abc;
	
	@GetMapping("/")
	Disease getHello()
	{
		return abc.fun();
	}
	
	
}
