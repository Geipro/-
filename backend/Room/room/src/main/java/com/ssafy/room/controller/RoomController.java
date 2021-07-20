package com.ssafy.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.room.dto.PageBean;
import com.ssafy.room.dto.Room;
import com.ssafy.room.service.RoomService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/room")
public class RoomController {
	
	@Autowired
	private RoomService rService;
	
	// 방 정보 보기
	@GetMapping()
	public ResponseEntity<List<Room>> room(@RequestBody PageBean pagebean){
		return new ResponseEntity<List<Room>>(rService.searchAll(pagebean), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Room> createRoom(@RequestBody Room room){
		return new ResponseEntity<Room>(rService.insertRoom(room), HttpStatus.OK);
	}
	
	@GetMapping("{room_id}")
	public ResponseEntity<Room> searchRoom(@PathVariable int room_id){
		return new ResponseEntity<Room>(rService.searchRoom(room_id), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Room> updateRoom(@RequestBody Room room){
		return new ResponseEntity<Room>(rService.updateRoom(room), HttpStatus.OK);
	}
	
	@DeleteMapping("{room_id}")
	public ResponseEntity<Boolean> deleteRoom(@PathVariable int room_id){
		return new ResponseEntity<Boolean>(rService.deleteRoom(room_id), HttpStatus.OK);
	}
	
	
	
	
}
