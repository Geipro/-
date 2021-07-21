package com.ssafy.common.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ssafy.api.service.UserService;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepository;


/**
 * ���� �׼��� ��ū���� ���� ������ ������ ������(Ȱ��ȭ ����, ����, �� ��) ���� ���� ����.
 */
@Component
public class SsafyUserDetailService implements UserDetailsService{
	@Autowired
	UserService userService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    		User user = userService.getUserByUserId(username);
    		if(user != null) {
    			SsafyUserDetails userDetails = new SsafyUserDetails(user);
    			return userDetails;
    		}
    		return null;
    }
}
