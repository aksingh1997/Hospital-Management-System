package com.HospitalManagementSystem.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.HospitalManagementSystem.Doctor.Entity.Doctor;
import com.HospitalManagementSystem.Doctor.Entity.Nurse;
import com.HospitalManagementSystem.Doctor.Entity.PatientAllocation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DoctorService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PatientAllocationJPA patientAllocationRepo;
	
	
	@HystrixCommand(fallbackMethod = "getPatientInfo_Fallback")
	public PatientInfo getPatientInfo(int id)
	{
		PatientInfo patientInfo = restTemplate.getForObject("http://Patient/patient/" + Integer.toString(id), PatientInfo.class);
		return patientInfo;
	}
	public PatientInfo getPatientInfo_Fallback(int id)
	{
		System.out.println("Patient service down");
		return new PatientInfo();
	}
	
	@HystrixCommand(fallbackMethod = "getNurse_Fallback")
	public Nurse getNurse(Doctor doctor)
	{
		return restTemplate.getForObject("http://Nurse/nurse/" + Integer.toString(doctor.getAllocatedNureseId()) , Nurse.class);
	}
	public Nurse getNurse_Fallback(Doctor doctor)
	{
		System.out.println("Nurse Service down");
		return new Nurse();
	}
}
