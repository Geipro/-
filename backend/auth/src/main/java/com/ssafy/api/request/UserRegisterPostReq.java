package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ���� ȸ������ API ([POST] /api/auth/join) ��û�� �ʿ��� ������Ʈ �ٵ� ����.
 */
@Getter
@Setter
@ApiModel("UserRegisterPostRequest")
public class UserRegisterPostReq {
	@ApiModelProperty(name="���� ID", example="ssafy_web")
	String id;
	@ApiModelProperty(name="���� Password", example="your_password")
	String password;
	@ApiModelProperty(name="���� email", example="your_email")
	String email;
	@ApiModelProperty(name="���� name", example="ȫ�浿")
	String username;
	@ApiModelProperty(name="���� ��ȭ��ȣ", example="01000000000")
	String phoneNum;
	@ApiModelProperty(name="���� �г���", example="�г���")
	String nickname;
}
