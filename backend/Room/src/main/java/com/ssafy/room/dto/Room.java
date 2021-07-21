package com.ssafy.room.dto;

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
@Table(name="Room")
@Entity
public class Room {
	// GenerationType.IDENTITY를 통해서 AutoIncrease가 가능 -> 기본키 생성을 데이터베이스에 위임한다
	// ID - 기본키
	// 여기서 underbar는 인식이 잘 되지 않으므로 전부 제거
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private int roomid;
	
	@Column(name="game_id")
	private int gameid;
	private String name;
	private String password;
	private boolean playing;
	public int getRoomid() {
		return roomid;
	}
	public int getGameid() {
		return gameid;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public boolean isPlaying() {
		return playing;
	}
	
}
