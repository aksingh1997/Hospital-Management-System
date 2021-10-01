package com.HospitalManagementSystem.Patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disease {
	 @Id
	 @Column
	 int diseaseId;
	 @Column
	 String name;
	 @Column
	 int costToCure;
	 
	public int getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCostToCure() {
		return costToCure;
	}
	public void setCostToCure(int costToCure) {
		this.costToCure = costToCure;
	}
	 
	 
}

