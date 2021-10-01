package com.HospitalManagementSystem.Doctor.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Doctor {
	
	@Id
	@Column
	int doctId;
	
	@Column
	String name;
	
	@Column
	int Experince;
	
	@Column
	int allocatedNureseId;
	
	
	public int getDoctId() {
		return doctId;
	}

	public void setDoctId(int doctId) {
		this.doctId = doctId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperince() {
		return Experince;
	}

	public void setExperince(int experince) {
		Experince = experince;
	}

	public int getAllocatedNureseId() {
		return allocatedNureseId;
	}

	public void setAllocatedNureseId(int allocatedNureseId) {
		this.allocatedNureseId = allocatedNureseId;
	}

	
}
