package com.ssafy.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.room.dto.PageBean;
import com.ssafy.room.dto.Room;
import com.ssafy.room.repository.RoomRespository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRespository roomRespository;

	@Override
	public List<Room> searchAll(PageBean bean) {
		// 한번에 6개 출력
		bean.setInterval(6);
		return null;
	}

	@Override
	public Room searchRoom(int room_id) {
		return roomRespository.findRoomByRoomid(room_id);
	}

	@Override
	public Room insertRoom(Room room) {
		return null;
	}

	@Override
	public Room updateRoom(Room room) {
		return null;
	}

	@Override
	public boolean deleteRoom(int room_id) {
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("A");
		RoomService roomService = new RoomServiceImpl();
		System.out.println("B");
		Room room = roomService.searchRoom(1);
		System.out.println("C");
		
	}
}
