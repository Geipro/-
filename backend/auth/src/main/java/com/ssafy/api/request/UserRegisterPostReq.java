package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ���� ȸ������ API ([POST] /api/v1/users) ��û�� �ʿ��� ������Ʈ �ٵ� ����.
 */
@Getter
@Setter
@ApiModel("UserRegisterPostRequest")
public class UserRegisterPostReq {
	@ApiModelProperty(name="���� ID", example="ssafy_web")
	String id;
	@ApiModelProperty(name="���� Password", example="your_password")
	String password;
}
