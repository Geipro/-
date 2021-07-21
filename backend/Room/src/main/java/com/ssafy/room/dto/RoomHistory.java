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
@Table(name="Room_History")
@Entity
public class RoomHistory {
	
	@Id
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="game_title")
	private String gameTitle;
	private String name;
	private String owner;
	
	@Column(name="created_at")
	private Timestamp createdat;
	
	@Column(name="finished_at")
	private Timestamp finishedat;
	
	public RoomHistory() {}
	
	public RoomHistory(Room room) {
		this.roomId = room.getRoomId();
		this.gameTitle = room.getGameTitle();
		this.name = room.getName();
		this.owner = room.getOwner();	
		this.createdat = room.getCreated_at();
		this.finishedat = new Timestamp(System.currentTimeMillis());
	}
	
	
	public int getRoomId() {
		return roomId;
	}
	public String getGameTitle() {
		return gameTitle;
	}
	public String getName() {
		return name;
	}
	
	public String getOwner() {
		return owner;
	}
	public Timestamp getCreated_at() {
		return createdat;
	}
	public Timestamp getFinishedat() {
		return finishedat;
	}


	@Override
	public String toString() {
		return "RoomHistory [roomId=" + roomId + ", gameTitle=" + gameTitle + ", name=" + name + ", owner=" + owner
				+ ", createdat=" + createdat + ", finishedat=" + finishedat + "]";
	}
	
}
