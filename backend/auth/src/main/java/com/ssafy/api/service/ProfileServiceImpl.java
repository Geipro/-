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
	public Profile getProfileByNickname(String nickname) {
		Profile profile = profileRepositorySupport.findProfileByNickname(nickname).get();
		return profile;
	}
<<<<<<< HEAD
=======
	
	@Override
	public Profile getProfileByUserId(String userId) {
		Profile profile = profileRepositorySupport.findProfileByUserId(userId).get();
		return profile;
	}
>>>>>>> develop

	@Override
	public boolean checkName(String nickname) {
		return profileRepository.existsByNickname(nickname);
	}

	@Override
	public boolean changeProfileInfo(String userId, String nickname, String aboutMe) {
		Profile profile = profileRepositorySupport.findProfileByUserId(userId).get();
		profile.setNickname(nickname);
		profile.setAbout_me(aboutMe);
		profileRepository.save(profile);
		return true;
	}
}
