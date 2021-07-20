package com.ssafy.room.service;

import java.util.List;
import java.util.Optional;

import com.ssafy.room.dto.Room;
import com.ssafy.room.dto.RoomSortInfo;

public interface RoomService {
	public Optional<List<Room>>  searchAll(RoomSortInfo sortInfo);

	// Optional - Integer, Double 처럼 T타입을 포장해주는 객체
	// 만약 객체가 없다고 한다면 null값이 들어올 수 있다.
	public Optional<Room> searchRoom(int room_id);
	public Room insertRoom(Room room);
	public Room updateRoom(Room room);
	public boolean deleteRoom(int room_id);
}
