package com.HospitalManagementSystem.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalManagementSystem.Doctor.Entity.Doctor;

public interface DoctorJPA extends JpaRepository<Doctor, Integer>{

}