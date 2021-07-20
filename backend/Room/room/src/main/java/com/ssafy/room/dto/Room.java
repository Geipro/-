package com.ssafy.room.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Table(name="Room")
@Entity
public class Room {
	// GenerationType.IDENTITY를 통해서 AutoIncrease가 가능 -> 기본키 생성을 데이터베이스에 위임한다
	// ID - 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int roomid;
	
	// @Column -> 데이터베이스 이름과 Class이름이 다르면 사용하기
	
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
