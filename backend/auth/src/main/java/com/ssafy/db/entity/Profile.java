package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * ���� �� ����.
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
