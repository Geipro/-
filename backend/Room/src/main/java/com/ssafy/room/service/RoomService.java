package com.ssafy.room.service;

import java.util.List;
import java.util.Optional;

import com.ssafy.room.dto.Game;
import com.ssafy.room.dto.Room;
import com.ssafy.room.dto.RoomSortInfo;

public interface RoomService {
	public List<Room>  searchAll(RoomSortInfo sortInfo);

	// Optional - Integer, Double 처럼 T타입을 포장해주는 객체
	// 만약 객체가 없다고 한다면 null값이 들어올 수 있다.
	public Optional<Room> searchRoom(int room_id);
	public Game insertRoom(Room room);
	public Game updateRoom(Room room);
	public boolean saveRoom(int room_id);
}
