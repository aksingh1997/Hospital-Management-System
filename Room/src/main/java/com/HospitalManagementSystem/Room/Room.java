package com.HospitalManagementSystem.Room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

	@Id
	@Column
	int roomId;
	
	@Column
	int size;
	
	@Column
	int IsAC;
	
	@Column
	int chargePerDay;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	

	public int getIsAC() {
		return IsAC;
	}

	public void setIsAC(int isAC) {
		IsAC = isAC;
	}

	public int getChargePerDay() {
		return chargePerDay;
	}

	public void setChargePerDay(int chargePerDay) {
		this.chargePerDay = chargePerDay;
	}
	
	
}
