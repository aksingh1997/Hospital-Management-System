package com.HospitalManagementSystem.Doctor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.HospitalManagementSystem.Doctor.Entity.Doctor;
import com.HospitalManagementSystem.Doctor.Entity.Nurse;
import com.HospitalManagementSystem.Doctor.Entity.PatientAllocation;

@RestController
public class DoctorController {

	@Autowired
	DoctorJPA doctorRepo;
	
	@Autowired
	PatientAllocationJPA patientAllocationRepo;
	
	@Autowired 
	DoctorService doctorService;
	
	@PostMapping("/doctor")
	String addDoctor(@RequestBody Doctor doctor)
	{
		doctorRepo.save(doctor);
		return "Saved doctor";
	}

	
	@GetMapping("/doctor/{id}")
	DoctInfo getDoctor(@PathVariable("id") int id)
	{
		Doctor doctor = doctorRepo.findById(id).orElse(new Doctor());
		return setDoctDetails(doctor);
	}
	
	@GetMapping("/doctor/name/{id}")
	String getDoctorName(@PathVariable("id") int id)
	{
		Doctor doctor = doctorRepo.findAll().stream().filter(x -> x.getDoctId() == id).findAny().orElse(new Doctor());
		return doctor.getName();
	}
	
	@PostMapping("/allocate")
	String allocatePatient(@RequestBody PatientAllocation patientAllocation)
	{
		patientAllocationRepo.save(patientAllocation);
		return "Patient Allocated";
	}
	
	@GetMapping("/allocate/{id}")
	List<PatientAllocation> getPatientAllocation(@PathVariable("id") int id)
	{
		return patientAllocationRepo.findAll().stream().filter(x -> x.getDoctId() == id).collect(Collectors.toList());
	}
	
	
	public DoctInfo setDoctDetails(Doctor doctor)
	{
		// set Doctor details
		DoctInfo doctInfo = new DoctInfo();
		doctInfo.setDoctor(doctor);
		
		// set Patient List
		List<PatientAllocation> patientsIdList = patientAllocationRepo.findAll().stream().filter(x -> x.getDoctId() == doctor.getDoctId()).collect(Collectors.toList());
		List<PatientInfo> ans = patientsIdList.stream().map(x -> doctorService.getPatientInfo(x.getPatientId())).collect(Collectors.toList());
		doctInfo.setListOfPatients(ans);
		
		//set Nurse Info
		Nurse nurse = doctorService.getNurse(doctor);
		doctInfo.setAllocatedNurse(nurse);
		
		return doctInfo;
	}
}
