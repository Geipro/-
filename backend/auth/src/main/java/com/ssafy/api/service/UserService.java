package com.ssafy.api.service;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.User;

/**
 *	���� ���� ����Ͻ� ���� ó���� ���� ���� �������̽� ����.
 */
public interface UserService {
	User createUser(UserRegisterPostReq userRegisterInfo);
	User getUserByEmail(String email);
	boolean checkEmail(String email);
}
