package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.db.entity.Profile;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.ProfileRepository;
import com.ssafy.db.repository.ProfileRepositorySupport;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	ProfileRepositorySupport profileRepositorySupport;
	
	@Override
	public Profile getUserByNickname(String nickname) {
		Profile profile = profileRepositorySupport.findUserByNickname(nickname).get();
		return profile;
	}
	
	@Override
	public Profile getUserByUserId(String userId) {
		Profile profile = profileRepositorySupport.findUserByUserId(userId).get();
		return profile;
	}

	@Override
	public boolean checkName(String nickname) {
		return profileRepository.existsByNickname(nickname);
	}

	@Override
	public boolean changeProfileInfo(String userId, String nickname, String aboutMe) {
		Profile profile = profileRepositorySupport.findUserByUserId(userId).get();
		profile.setNickname(nickname);
		profile.setAbout_me(aboutMe);
		profileRepository.save(profile);
		return true;
	}
}
