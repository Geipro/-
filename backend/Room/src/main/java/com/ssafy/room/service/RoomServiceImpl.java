package com.ssafy.room.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssafy.room.dto.Game;
import com.ssafy.room.dto.Room;
import com.ssafy.room.dto.RoomResult;
import com.ssafy.room.dto.RoomSortInfo;
import com.ssafy.room.repository.GameRespository;
import com.ssafy.room.repository.RoomResultRespository;
import com.ssafy.room.repository.RoomRespository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRespository roomRespository;
	
	@Autowired
	private RoomResultRespository roomResultRespository;
	
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
		Game game =  gameRespository.findGameByGameTitle(room.getGameType());
		// game을 어떠한 방식으로 넣어줘야 되는지
		return gameRespository.findGameByGameTitle(room.getGameType());
	}

	@Override
	public Game updateRoom(Room room) {
		roomRespository.save(room);
		return gameRespository.findGameByGameTitle(room.getGameType());
	}

	@Override
	public boolean saveRoom(RoomResult roomResult) {
		roomResultRespository.save(roomResult);
		// roomUserRespositoy.save(???)
		return true;
	}
	
	@Override
	public Integer random() {
		List<Room> rooms = roomRespository.findRoomByPlaying(true);
		if(rooms.size() == 0) return -1;
		return rooms.get(new Random().nextInt(rooms.size())).getRoomId();
	}
}
