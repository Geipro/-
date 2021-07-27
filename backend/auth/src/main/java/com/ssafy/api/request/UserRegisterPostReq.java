package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 회원가입 API ([POST] /api/auth/join) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserRegisterPostRequest")
public class UserRegisterPostReq {
	
	@ApiModelProperty(name="유저 ID", example="ssafy_web") 
	String id;
	
	@ApiModelProperty(name="유저 Password", example="your_password")
	String password;
	@ApiModelProperty(name="유저 email", example="your_email")
	String email;
	@ApiModelProperty(name="유저 name", example="홍길동")
	String username;
	@ApiModelProperty(name="유저 전화번호", example="01000000000")
	String phoneNum;
	@ApiModelProperty(name="유저 닉네임", example="닉네임")
	String nickname;
}
