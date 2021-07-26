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
import com.ssafy.room.dto.RoomChange;
import com.ssafy.room.dto.RoomResult;
import com.ssafy.room.dto.RoomSortInfo;
import com.ssafy.room.repository.GameRespository;
import com.ssafy.room.repository.RoomResultRespository;
import com.ssafy.room.repository.RoomUserRespository;
import com.ssafy.room.repository.RoomRespository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRespository roomRespository;
	
	@Autowired
	private RoomResultRespository roomResultRespository;
	
	@Autowired
	private GameRespository gameRespository;
	
	@Autowired
	private RoomUserRespository roomUserRespository;

	@Override
	public List<Room> searchAll(RoomSortInfo sortInfo) {
		Sort sort	;
		if(sortInfo.sortKey == "") {
			sort = sortInfo.order ? Sort.by("roomId").ascending() : Sort.by("roomId").descending();
		} else {
			sort = sortInfo.order ? Sort.by(sortInfo.sortKey).ascending() : Sort.by(sortInfo.sortKey).descending();
		}
		if(sortInfo.searchKey == "name") {
			return roomRespository.findRoomByRoomTitle(sortInfo.searchWord, sort);
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
//		Game game =  gameRespository.findGameByGameType(room.getGameType());
		// game을 어떠한 방식으로 넣어줘야 되는지
		return gameRespository.findGameByGameType(room.getGameType());
	}

	@Override
	public Game updateRoom(RoomChange roomChange) {
		Room room = roomRespository.getById(roomChange.getRoomId());
		room.roomChanging(roomChange);
		roomRespository.save(room);
		return gameRespository.findGameByGameType(room.getGameType());
	}

	@Override
	public boolean saveRoom(RoomResult roomResult) {
		roomResultRespository.save(roomResult);
		return true;
	}
	
	@Override
	public Integer random() {
		List<Room> rooms = roomRespository.findAll();
		List<RoomResult> roomResult = roomResultRespository.findAll();
		if(rooms.size() == 0) return -1;
		// 여기서 빈방을 찾을 때 까지 계속 진행하는 알고리즘 구현
		// 알고리즘 구현 후에 빈방이 나오면 전송
		return rooms.get(new Random().nextInt(rooms.size())).getRoomId();
	}
	
	@Override
	public RoomResult getResult(int room_id) {
		return roomResultRespository.findRoomResultByRoomId(room_id);
	}
}
