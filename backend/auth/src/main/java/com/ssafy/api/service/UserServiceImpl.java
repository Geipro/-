package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.Profile;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.ProfileRepository;
import com.ssafy.db.repository.ProfileRepositorySupport;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

/**
 *	���� ���� ����Ͻ� ���� ó���� ���� ���� ���� ����.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRepositorySupport userRepositorySupport;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User createUser(UserRegisterPostReq userRegisterInfo) {
		User user = new User();
		/*
		 * userId ��ȣȭ ����
		 */
		String userId = ""; 
		user.setUserId(userId);
		user.setEmail(userRegisterInfo.getEmail());
		// ������ ���ؼ� ���� �н����� ��ȣȭ �Ͽ� ��� ����.
		user.setPassword(passwordEncoder.encode(userRegisterInfo.getPassword()));
		user.setUsername(userRegisterInfo.getUsername());
		
		Profile profile = new Profile();
		profile.setUserId(userId);
		profile.setNickname(userRegisterInfo.getNickname());
		profile.setPhoneNum(userRegisterInfo.getPhoneNum());
		return userRepository.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		// ��� ���� ���� ��ȸ (userId �� ���� ��ȸ).
		User user = userRepositorySupport.findUserByEmail(email).get();
		return user;
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepository.existsByEmail(email);
	}
}
