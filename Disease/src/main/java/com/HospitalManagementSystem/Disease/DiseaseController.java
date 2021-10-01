package com.HospitalManagementSystem.Disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiseaseController {

	@Autowired
	DiseaseJPA repo;
	
	@GetMapping("/disease/{id}")
	Disease getDiseaseInfo(@PathVariable("id") int id)
	{
		return repo.findById(id).orElse(new Disease());
	}
	
	@PostMapping("/disease")
	String setDiseaseInfo(@RequestBody Disease disease)
	{
		repo.save(disease);
		return "Info saved";
	}
}
