package com.ssafy.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.room.dao.RoomDao;
import com.ssafy.room.dto.PageBean;
import com.ssafy.room.dto.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao dao;

	@Override
	public List<Room> searchAll(PageBean bean) {
		// 한번에 6개 출력
		bean.setInterval(6);
		int total = dao.totalCount();
		
		return dao.searchAll(bean);
	}

	@Override
	public Room searchRoom(int room_id) {
		return dao.searchRoom(room_id);
	}

	@Override
	public Room insertRoom(Room room) {
		return dao.insertRoom(room);
	}

	@Override
	public Room updateRoom(Room room) {
		return dao.updateRoom(room);
	}

	@Override
	public boolean deleteRoom(int room_id) {
		return dao.deleteRoom(room_id);
	}
	
	
}
