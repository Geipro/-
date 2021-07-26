package com.ssafy.room.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomSortInfo {
	public String searchKey;
	public String searchWord;
	public String sortKey;
	public boolean order = true;
	

	// true - 오름차순, false - 내림차순
	@Override
	public String toString() {
		return "RoomSortInfo [searchKey=" + searchKey + ", searchWord=" + searchWord + ", sortKey=" + sortKey
				+ ", order=" + order + "]";
	}
	
}
