package com.ssafy.room.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="Room_user")
@Entity
public class RoomUser {
	
	@Column(name="room_id")
	private int roomID;
	
	@Column(name="user_id")
	private String userID;
	
	private boolean finished;
	
	private int point;
}
