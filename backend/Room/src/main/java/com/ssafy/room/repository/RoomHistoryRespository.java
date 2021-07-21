package com.ssafy.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.room.dto.RoomHistory;

@Repository
public interface RoomHistoryRespository extends JpaRepository<RoomHistory, Integer> {
	
}
