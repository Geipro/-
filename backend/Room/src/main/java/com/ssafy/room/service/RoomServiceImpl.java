package com.ssafy.room.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssafy.room.dto.Game;
import com.ssafy.room.dto.Room;
import com.ssafy.room.dto.RoomHistory;
import com.ssafy.room.dto.RoomSortInfo;
import com.ssafy.room.repository.GameRespository;
import com.ssafy.room.repository.RoomHistoryRespository;
import com.ssafy.room.repository.RoomRespository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRespository roomRespository;
	
	@Autowired
	private RoomHistoryRespository roomHistoryRespository;
	
	@Autowired
	private GameRespository gameRespository;

	@Override
	public List<Room> searchAll(RoomSortInfo sortInfo) {
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
	public Game insertRoom(Room room) {
		room.setCreatedat(new Timestamp(System.currentTimeMillis()));
		roomRespository.save(room);
		Game game =  gameRespository.findGameByGameTitle(room.getGameTitle());
		return gameRespository.findGameByGameTitle(room.getGameTitle());
	}

	@Override
	public Game updateRoom(Room room) {
		roomRespository.save(room);
		return gameRespository.findGameByGameTitle(room.getGameTitle());
	}

	@Override
	public boolean saveRoom(int room_id) {
		Room room = roomRespository.findRoomByRoomId(room_id);
		RoomHistory roomHistory = new RoomHistory(room);
		
		System.out.println(roomHistory.toString());
		
		roomHistoryRespository.save(roomHistory);
		return true;
	}
}
