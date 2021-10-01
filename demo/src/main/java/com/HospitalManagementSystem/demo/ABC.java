package com.HospitalManagementSystem.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.HospitalManagementSystem.Entity.Disease;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ABC{
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "Disease_fallback")
	public Disease fun()
	{
		System.out.println("Inside main function");
		Disease disease = restTemplate.getForObject("http://disease/disease/1", Disease.class);
		return disease;
	}
	
	public Disease Disease_fallback()
	{
		System.out.println("Can't reach disease");
		return new Disease();
		
	}
}
