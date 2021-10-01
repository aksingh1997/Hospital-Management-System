package com.HospitalManagementSystem.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	RoomJPA repo;
	
	@PostMapping("/room")
	String setRoomInfo(@RequestBody Room room)
	{
		repo.save(room);
		return "Room Info added";
	}
	
	@GetMapping("/room/{id}")
	Room getRoomInfo(@PathVariable("id") int id)
	{
		return repo.findById(id).orElse(new Room());
	}
}
