package com.ssafy.api.service;

import com.ssafy.db.entity.Profile;

public interface ProfileService {
	Profile getUserByNickname(String nickname);
	Profile getUserByUserId(String userId);
	boolean checkName(String nickname);
	boolean changeProfileInfo(String userId, String nickname, String aboutMe);
}