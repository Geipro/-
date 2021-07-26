package com.ssafy.api.response;

import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Profile;
import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ȸ�� ���� ��ȸ API ([GET] /api/profile/{nickname}) ��û�� ���� ���䰪 ����.
 */
@Getter
@Setter
@ApiModel("UserResponse")
public class UserRes{
	@ApiModelProperty(name="nickname")
	String nickname;
	/*
	 * �߰�
	 */
	@ApiModelProperty(name="phoneNum")
	String phoneNum;
	@ApiModelProperty(name="aboutMe")
	String aboutMe;
	@ApiModelProperty(name="totalpoint")
	int totalPoint;
	
	public static UserRes of(Profile profile) {
		UserRes res = new UserRes();
		res.setNickname(profile.getNickname());
		res.setPhoneNum(profile.getPhoneNum());
		res.setAboutMe(profile.getAbout_me());
		res.setTotalPoint(profile.getTotalPoint());
		return res;
	}
}
