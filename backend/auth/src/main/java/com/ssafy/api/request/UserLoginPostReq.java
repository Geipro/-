package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ���� �α��� API ([POST] /api/auth/login) ��û�� �ʿ��� ������Ʈ �ٵ� ����.
 */
@Getter
@Setter
@ApiModel("UserLoginPostRequest")
public class UserLoginPostReq {
	@ApiModelProperty(name="���� email", example="ssafy_web")
	String email;
	@ApiModelProperty(name="���� Password", example="your_password")
	String password;
}
