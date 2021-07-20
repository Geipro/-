package com.ssafy.room.service;

import java.util.List;

import com.ssafy.room.dto.PageBean;
import com.ssafy.room.dto.Room;

public interface RoomService {
	public List<Room> searchAll(PageBean bean);

	public Room searchRoom(int room_id);
	public Room insertRoom(Room room);
	public Room updateRoom(Room room);
	public boolean deleteRoom(int room_id);
}
