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
	String profile_id;
    String user_id;
    String audio;
    String mic;
    String camera;
}
