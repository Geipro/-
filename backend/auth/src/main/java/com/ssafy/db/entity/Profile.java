package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Profile DB
 */
@Entity
@Getter
@Setter
public class Profile extends BaseEntityForProfile {
	//String profileId;
	
    String userId;
    
    @Column(name="nickname", unique=true)
    String nickname;
    
    String phoneNum;
    String about_me;
    
    String audio;
    String mic;
    String camera;
    
    String profile_img;
    String back_img;
    
    int totalPoint;
}
