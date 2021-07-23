package com.ssafy.room.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="room")
@Entity
public class Room {
	// GenerationType.IDENTITY를 통해서 AutoIncrease가 가능 -> 기본키 생성을 데이터베이스에 위임한다
	// ID - 기본키
	// 여기서 underbar는 인식이 잘 되지 않으므로 전부 제거
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="game_type")
	private String gameType;
	
	@Column(name="room_title")
	private String roomTitle;

	@Column(name="room_owner")
	private String roomOwner;
	
	@Column(name="created_at")
	private Timestamp createdat;
	
	@Column(name="room_status")
	private String roomStatus;
	
	public int getRoomId() {
		return roomId;
	}

	public String getGameType() {
		return gameType;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public String getRoomOwner() {
		return roomOwner;
	}

	public Timestamp getCreatedat() {
		return createdat;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setCreatedat(Timestamp createdat) {
		this.createdat = createdat;
	}
}
