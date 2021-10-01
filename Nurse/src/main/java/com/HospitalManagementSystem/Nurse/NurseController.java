package com.HospitalManagementSystem.Nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NurseController {

	@Autowired
	NurseJPA nurseRepo;
	
	@PostMapping("/nurse")
	String setNurseInfo(@RequestBody Nurse nurse)
	{
		nurseRepo.save(nurse);
		return "Nurse Info Saved";
	}
	
	@GetMapping("/nurse/{id}")
	Nurse getNurseInfor(@PathVariable("id") int id)
	{
		return nurseRepo.findById(id).orElse(new Nurse());
	}
}
