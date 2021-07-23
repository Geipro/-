package com.ssafy.room.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="RoomResult")
@Entity
public class RoomResult {
	
	@Id
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="game_type")
	private String gameType;
	
	@Column(name="user_id")
	private String userId;
	
	private String point;
	
	private String result;
	
	@Column(name="finished_at")
	private Timestamp finishedat;

	public int getRoomId() {
		return roomId;
	}

	public String getGameType() {
		return gameType;
	}

	public String getUserId() {
		return userId;
	}

	public String getPoint() {
		return point;
	}

	public String getResult() {
		return result;
	}

	public Timestamp getFinishedat() {
		return finishedat;
	}
	
	
	
}
