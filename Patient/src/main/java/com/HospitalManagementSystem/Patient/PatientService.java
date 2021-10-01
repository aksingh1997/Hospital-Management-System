package com.HospitalManagementSystem.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PatientService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getRoom_Fallback")
	public Room getRoom(Patient patient)
	{
		return restTemplate.getForObject("http://room/room/" + Integer.toString(patient.getRoomId()), Room.class);
	}
	public Room getRoom_Fallback(Patient patient)
	{
		System.out.println("Room microservice is down");
		return new Room();
	}
	
	@HystrixCommand(fallbackMethod = "getDisease_Fallback")
	public Disease getDisease(Patient patient)
	{
		return restTemplate.getForObject("http://disease/disease/" + Integer.toString(patient.getDiseaseId()), Disease.class);
	}
	public Disease getDisease_Fallback(Patient patient)
	{
		System.out.println("Disease microservice is down");
		return new Disease();
	}
	
	@HystrixCommand(fallbackMethod = "getDoctName_Fallback")
	public String getDoctName(Patient patient)
	{
		return restTemplate.getForObject("http://doctor/doctor/name/" + Integer.toString(patient.getDoctId()), String.class);
	}
	public String getDoctName_Fallback(Patient patient)
	{
		System.out.println("Patient Service is down");
		return "Not available";
	}
}
