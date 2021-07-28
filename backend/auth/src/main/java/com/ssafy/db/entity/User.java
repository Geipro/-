package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * User DB
 */
@Entity
@Getter
@Setter
public class User extends BaseEntity{
	@Id
    String userId;
	
	@Column(name="email", unique=true)
    String email;
	
    String username;
    int userStatus;
    
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    
    // 
}
