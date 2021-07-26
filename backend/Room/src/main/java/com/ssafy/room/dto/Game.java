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
@Table(name="game")
@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="game_type")
	private String gameType;
	
	private String info;
	
	@Column(name="max_user")
	private int maxUser;

	public String getGameType() {
		return gameType;
	}

	public String getInfo() {
		return info;
	}

	public int getMaxUser() {
		return maxUser;
	}
	
	
}
