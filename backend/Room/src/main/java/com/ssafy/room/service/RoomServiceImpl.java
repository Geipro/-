package com.ssafy.room.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssafy.room.dto.Room;
import com.ssafy.room.dto.RoomSortInfo;
import com.ssafy.room.repository.RoomRespository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRespository roomRespository;

	@Override
	public Optional<List<Room>> searchAll(RoomSortInfo sortInfo) {
		Sort sort;
		if(sortInfo.sortKey == "") {
			sort = sortInfo.order ? Sort.by("room_id").ascending() : Sort.by("room_id").descending();
		} else {
			sort = sortInfo.order ? Sort.by(sortInfo.sortKey).ascending() : Sort.by(sortInfo.sortKey).descending();
		}
		if(sortInfo.searchKey == "name") {
			return roomRespository.findRoomByName(sortInfo.searchWord, sort);
		}
		return roomRespository.findAll(sort);
	}

	@Override
	public Optional<Room> searchRoom(int room_id) {
		return roomRespository.findById(room_id);
	}

	@Override
	public Room insertRoom(Room room) {
		return roomRespository.save(room);
	}

	@Override
	public Room updateRoom(Room room) {
		return roomRespository.save(room);
	}

	@Override
	public boolean deleteRoom(int room_id) {
		roomRespository.deleteById(room_id);
		return true;
	}
}
