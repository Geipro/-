package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Profile;
import com.ssafy.db.entity.QProfile;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QProfile qProfile = QProfile.profile;
	
	public Optional<Profile> findProfileByNickname(String nickname){
    	Profile profile = jpaQueryFactory.select(qProfile).from(qProfile).where(qProfile.nickname.eq(nickname)).fetchOne();
    	if(profile == null)
    		return Optional.empty();
    	return Optional.ofNullable(profile);
    }
<<<<<<< HEAD
=======

	public Optional<Profile> findProfileByUserId(String userId) {
    	Profile profile = jpaQueryFactory.select(qProfile).from(qProfile).where(qProfile.userId.eq(userId)).fetchOne();
    	if(profile == null)
    		return Optional.empty();
    	return Optional.ofNullable(profile);
	}
>>>>>>> develop
}
