package com.HospitalManagementSystem.Doctor.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PatientAllocation {
	
	@Id
	@Column
	@GeneratedValue
	int serNo;
	
	@Column
	int doctId;
	
	@Column
	int patientId;

	public int getSerNo() {
		return serNo;
	}

	public void setSerNo(int serNo) {
		this.serNo = serNo;
	}

	public int getDoctId() {
		return doctId;
	}

	public void setDoctId(int doctId) {
		this.doctId = doctId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	
}
