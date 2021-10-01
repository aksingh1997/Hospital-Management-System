# Hospital-Management-System
## A simple spring boot microservices project for Hospital Management

Active microservices in this project are = 
1. Doctor
2. Patient
3. Disease
4. Room
5. Nurse
6. Eureka Server

* "Doctor" contains controller at location - "Hospital-Management-System/Doctor/src/main/java/com/HospitalManagementSystem/Doctor/DoctorController.java".
  * The controllers and its function are as follows -
          a. @PostMapping("/doctor") = Saves the information about the doctor in database. Uses JPA repository for conversion of Doctor.class to MySQL table.
          b. @GetMapping("/doctor/{id}") = Gives detailed infromation about the doctor, allocated nurse and the list of patients he is handling.
          c. @GetMapping("/doctor/name/{id}") = Provides name to the requested endpoint
          d. @PostMapping("/allocate") = To allocate patients to a doctor. We need to simply provide 'doctID' and 'patientId' and pateint gets allocated.
          e. @GetMapping("/allocate/{id}") = It provides all the patients that are allocated for a particular doctor.

* "Patient" contains controller at location - "Hospital-Management-System/Patient/src/main/java/com/HospitalManagementSystem/Patient/PatientController.java"
  * The controllers and its function are as follows -
          a. @PostMapping("/patient") = Saves the patient info as per provied in patient.class
          b. @GetMapping("/patient/{id}") = Gives detailed information about the patient, his allocated room details, his bill information, diesease information.
  
* "Nurse" contains controller at location - "Hospital-Management-System/Nurse/src/main/java/com/HospitalManagementSystem/Nurse/NurseController.java"
  * The controllers and its function are as follows -
          a. @PostMapping("/nurse") - Set the nurse Info
          b. @GetMapping("/nurse/{id}") - get the nurse Info
          
* "Disease" contains controller at location - "Hospital-Management-System/Disease/src/main/java/com/HospitalManagementSystem/Nurse/DiseaseController.java"
      The controllers and its function are as follows -
          a. @PostMapping("/disease") - Set the diease Info
          b. @GetMapping("/nurse/{id}") - get the disease Info
         
* "Room" contains controller at location - "Hospital-Management-System/Room/src/main/java/com/HospitalManagementSystem/Room/RoomController.java"
  * The controllers and its function are as follows -
          a. @PostMapping("/room") - Set the room Info
          b. @GetMapping("/nurse/{id}") - get the room Info
          
* "Eureka server" - All above mentioned microservices are connected to Eureka server. 
   
- Fallabck method is implemented usiing Hystrix
- We don't have to hardcode the URLs to when one microservice is calling to another microservice, thanks to Eureka Server Client
