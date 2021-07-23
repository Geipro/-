package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.QUser;
import com.ssafy.db.entity.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ���� �� ���� ��� ���� ������ ���� ���� ����.
 */
@Repository
public class UserRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QUser qUser = QUser.user;
//    QProfile qProfile = QProfile.profile;

    public Optional<User> findUserByEmail(String email) {
        User user = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.email.eq(email)).fetchOne();
        if(user == null) return Optional.empty();
        return Optional.ofNullable(user);
    }
    
//    public Optional<Profile> findUserByNickname(String nickname){
//    	Profile profile = jpaQueryFactory.select(qProfile).from(qProfile).where(qProfile.nickname.eq(nickname)).fetchOne();
//    	if(profile == null)
//    		return Optional.empty();
//    	return Optional.ofNullable(profile);
//    }
}
