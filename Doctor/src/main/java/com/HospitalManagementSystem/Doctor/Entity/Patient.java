package com.HospitalManagementSystem.Doctor.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	@Column
	int patientId;
	
	@Column
	String name;
	
	@Column
	int diseaseId;
	
	@Column
	int DoctId;
	
	@Column
	int roomId;
	
	@Column
	int noOfDaysStayed;
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}

	public int getDoctId() {
		return DoctId;
	}

	public void setDoctId(int doctId) {
		DoctId = doctId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getNoOfDaysStayed() {
		return noOfDaysStayed;
	}

	public void setNoOfDaysStayed(int noOfDaysStayed) {
		this.noOfDaysStayed = noOfDaysStayed;
	}

	
	
	
}