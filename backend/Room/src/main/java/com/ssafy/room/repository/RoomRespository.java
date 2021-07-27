package com.ssafy.room.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.room.dto.Room;

@Repository
public interface RoomRespository extends JpaRepository<Room, Integer> {
	Room findRoomByRoomId(Integer room_id);
	List<Room> findRoomByRoomTitle(String roomTitle, Sort sort);
	List<Room> findRoomByRoomStatus(String roomStatus);
	
}
