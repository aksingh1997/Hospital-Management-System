package com.HospitalManagementSystem.Doctor;

import java.util.List;

import com.HospitalManagementSystem.Doctor.Entity.Doctor;
import com.HospitalManagementSystem.Doctor.Entity.Nurse;



public class DoctInfo {
	
	Doctor doctor;
	List<PatientInfo> listOfPatients;
	Nurse allocatedNurse;

	

	public Nurse getAllocatedNurse() {
		return allocatedNurse;
	}

	public void setAllocatedNurse(Nurse allocatedNurse) {
		this.allocatedNurse = allocatedNurse;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<PatientInfo> getListOfPatients() {
		return listOfPatients;
	}

	public void setListOfPatients(List<PatientInfo> listOfPatients) {
		this.listOfPatients = listOfPatients;
	}


	
	
	
}
