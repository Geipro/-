package com.ssafy.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.room.dto.Game;

@Repository
public interface GameRespository extends JpaRepository<Game, Integer> {
	Game findGameByGameType(String game_type);
}
