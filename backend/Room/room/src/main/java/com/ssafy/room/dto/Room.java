package com.ssafy.room.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
	private int room_id;
	private int game_id;
	private String name;
	private String password;
	private boolean playing;
}
