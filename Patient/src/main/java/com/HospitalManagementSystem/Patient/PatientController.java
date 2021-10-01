package com.HospitalManagementSystem.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	
	
	@Autowired
	PatientJPA patientRepo;
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/patient")
	String setPatientInfo(@RequestBody Patient patient)
	{
		patientRepo.save(patient);
		return "patient info saved";
	}
	
	@GetMapping("/patient/{id}")
	PatientInfo getPatientInfo(@PathVariable("id") int id)
	{
		System.out.println("Getting the request");
		Patient patient =  patientRepo.findById(id).orElse(new Patient());
		PatientInfo patientInfo = setPatientDetails(patient);
		return patientInfo;
	}
	
	PatientInfo setPatientDetails(Patient patient)
	{
		PatientInfo patientInfo = new PatientInfo();
		//patient
		patientInfo.setPatient(patient);
		
		//room
		Room room = patientService.getRoom(patient);
		patientInfo.setRoom(room);
		
		//bill
		int room_rent = patientService.getRoom(patient).getChargePerDay();
		int costToCure = patientService.getDisease(patient).getCostToCure();
		int bill = costToCure + patient.getNoOfDaysStayed() * room_rent;
		patientInfo.setBill(bill);
		
		//Doctor's name
		String doctName = patientService.getDoctName(patient);
		patientInfo.setDoctName(doctName);
		
		//disease
		Disease disease = patientService.getDisease(patient);
		patientInfo.setDisease(disease);
		
		return patientInfo;
		
	}
}
