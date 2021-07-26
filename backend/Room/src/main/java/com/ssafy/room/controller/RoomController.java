package com.ssafy.room.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.room.dto.Game;
import com.ssafy.room.dto.Room;
import com.ssafy.room.dto.RoomChange;
import com.ssafy.room.dto.RoomResult;
import com.ssafy.room.dto.RoomSortInfo;
import com.ssafy.room.service.RoomService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/room")
public class RoomController {
	
	@Autowired
	private RoomService rService;
	
	// 방 정보 보기
	@GetMapping()
	public ResponseEntity<List<Room>> room(@RequestBody RoomSortInfo sortInfo){
		// 정렬 순서 입력 받기
		return new ResponseEntity<List<Room>>(rService.searchAll(sortInfo), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Game> createRoom(@RequestBody Room room){
		try {
			return new ResponseEntity<Game>(rService.insertRoom(room), HttpStatus.OK);
		}
		catch(Exception e) {
			// "Error" 에러 부분은 종류에 따라 수정
			return ResponseEntity.status(404).body(null);
		}
	}
	
	@GetMapping("{room_id}")
	public ResponseEntity<Optional<Room>> searchRoom(@PathVariable int room_id){
		return new ResponseEntity<Optional<Room>>(rService.searchRoom(room_id), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Game> updateRoom(@RequestBody RoomChange roomChange){
		try {
			return new ResponseEntity<Game>(rService.updateRoom(roomChange), HttpStatus.OK);
		}
		catch(Exception e) {
			// "Error" 에러 부분은 종류에 따라 수정
			return ResponseEntity.status(404).body(null);
		}
	}
	
	@GetMapping("/start/")
	public ResponseEntity<Boolean> startRoom(@RequestBody RoomResult roomResult){
		try {			
			return new ResponseEntity<Boolean>(rService.saveRoom(roomResult), HttpStatus.OK);
			
		}
		catch(Exception e) {
			return ResponseEntity.status(404).body(false);
		}
	}
	
	@GetMapping("/end/")
	public ResponseEntity<Boolean> saveRoom(@RequestBody RoomResult roomResult){
		try {			
			return new ResponseEntity<Boolean>(rService.saveRoom(roomResult), HttpStatus.OK);
			
		}
		catch(Exception e) {
			return ResponseEntity.status(404).body(false);
		}
	}
	
	@GetMapping("/random")
	public ResponseEntity<Integer> random(){
		return new ResponseEntity<Integer>(rService.random(), HttpStatus.OK);
	}
	
	@GetMapping("result/{room_id}")
	public ResponseEntity<RoomResult> roomResult(@PathVariable Integer room_id){
		return new ResponseEntity<RoomResult>(rService.getResult(room_id), HttpStatus.OK);
	}
	
}
