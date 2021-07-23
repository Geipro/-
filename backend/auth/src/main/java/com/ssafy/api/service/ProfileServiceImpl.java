package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.db.entity.Profile;
import com.ssafy.db.repository.ProfileRepository;
import com.ssafy.db.repository.ProfileRepositorySupport;

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
	public boolean checkName(String nickname) {
		return profileRepository.existsByNickname(nickname);
	}
}
