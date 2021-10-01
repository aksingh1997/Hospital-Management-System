package com.HospitalManagementSystem.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalManagementSystem.Doctor.Entity.PatientAllocation;

public interface PatientAllocationJPA extends JpaRepository<PatientAllocation, Integer>{

}
