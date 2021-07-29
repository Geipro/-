package com.ssafy.api.service;

import com.ssafy.db.entity.Profile;

public interface ProfileService {
<<<<<<< HEAD
	Profile getUserByNickname(String nickname);
=======
	Profile getProfileByNickname(String nickname);
	Profile getProfileByUserId(String userId);
>>>>>>> develop
	boolean checkName(String nickname);
	boolean changeProfileInfo(String userId, String nickname, String aboutMe);
}