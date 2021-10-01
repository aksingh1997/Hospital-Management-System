package com.HospitalManagementSystem.Nurse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NurseApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurseApplication.class, args);
	}

}
