package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 프로필 정보수정 API ([POST] /api/profile/modify) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserModifyInfo")
public class UserModifyInfoReq {
	/*
	 * 휴대폰 번호를 수정할 일이 있을까??
	 */
//	@ApiModelProperty(name="유저 전화번호", example="01000000000")
//	String phoneNum;
	@ApiModelProperty(name="유저 닉네임", example="닉네임")
	String nickname;
	@ApiModelProperty(name="유저 소개", example="개인에 대한 소개를 적어주세요!")
	String aboutMe;
}
