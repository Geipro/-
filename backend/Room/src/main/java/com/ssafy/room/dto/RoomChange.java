package com.ssafy.room.dto;

public class RoomChange {
	private int roomId;
	private String GameType;
	private String RoomTitle;
	private String RoomOwner;
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getGameType() {
		return GameType;
	}
	public void setGameType(String gameType) {
		GameType = gameType;
	}
	public String getRoomTitle() {
		return RoomTitle;
	}
	public void setRoomTitle(String roomTitle) {
		RoomTitle = roomTitle;
	}
	public String getRoomOwner() {
		return RoomOwner;
	}
	public void setRoomOwner(String roomOwner) {
		RoomOwner = roomOwner;
	}

	
}
