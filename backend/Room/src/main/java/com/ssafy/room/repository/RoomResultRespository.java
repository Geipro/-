package com.ssafy.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.room.dto.RoomResult;

@Repository
public interface RoomResultRespository extends JpaRepository<RoomResult, Integer> {
	RoomResult findRoomResultByRoomId(int roomid);
}
