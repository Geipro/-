package com.ssafy.common.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ssafy.db.entity.Profile;
import com.ssafy.db.entity.User;

/**
 * ���� �׼��� ��ū���� ���� ������ ������ �ΰ� ������(Ȱ��ȭ ����, ����, �� ��) ����.
 */
public class SsafyUserDetails implements UserDetails {
	@Autowired
	User user;
	@Autowired
	Profile profile;
	boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialNonExpired;
    boolean enabled = false;
    List<GrantedAuthority> roles = new ArrayList<>();
    
    public SsafyUserDetails(User user) {
    		super();
    		this.user = user;
    }
    
    public User getUser() {
    		return this.user;
    }
    public String getEmail() {
    	return this.user.getEmail();
    }
    public String getUserId() {
    	return this.user.getUserId();
    }
    public String getNickname() {
    	return this.profile.getNickname();
    }
    public String getPhoneNum() {
    	return this.profile.getPhoneNum();
    }
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	@Override
	public String getUsername() {
		return this.user.getUsername();
	}
	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialNonExpired;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	public void setAuthorities(List<GrantedAuthority> roles) {
		this.roles = roles;
	}
}
