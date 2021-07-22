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
	String profileid;
    String userid;
    String audio;
    String mic;
    String camera;
}
