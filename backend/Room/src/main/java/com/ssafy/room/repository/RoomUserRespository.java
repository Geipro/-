package com.ssafy.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.room.dto.RoomUser;

@Repository
public interface RoomUserRespository extends JpaRepository<RoomUser, Integer> {
}
