package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
public class Profile extends BaseEntity{
	String profileId;
    String userId;
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
