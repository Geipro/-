package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserLoginPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.service.UserService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepositorySupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * ���� ���� API ��û ó���� ���� ��Ʈ�ѷ� ����.
 */
@Api(value = "���� API", tags = {"Auth."})
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	@ApiOperation(value = "�α���", notes = "<strong>���̵�� �н�����</strong>�� ���� �α��� �Ѵ�.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "����", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "���� ����", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "����� ����", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "���� ����", response = BaseResponseBody.class)
    })
	public ResponseEntity<UserLoginPostRes> login(@RequestBody @ApiParam(value="�α��� ����", required = true) UserLoginPostReq loginInfo) {
		String userId = loginInfo.getId();
		String password = loginInfo.getPassword();
		
		User user = userService.getUserByUserId(userId);
		// �α��� ��û�� �����κ��� �Էµ� �н����� �� ��� ����� ������ ��ȣȭ�� �н����尡 ������ Ȯ��.(��ȿ�� �н��������� ���� Ȯ��)
		if(passwordEncoder.matches(password, user.getPassword())) {
			// ��ȿ�� �н����尡 �´� ���, �α��� �������� ����.(�׼��� ��ū�� �����Ͽ� ���䰪 ����)
			return ResponseEntity.ok(UserLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(userId)));
		}
		// ��ȿ���� �ʴ� �н������� ���, �α��� ���з� ����.
		return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "Invalid Password", null));
	}
	
	@PostMapping("/signup")
	@ApiOperation(value = "ȸ�� ����", notes = "<strong>���̵�� �н�����</strong>�� ���� ȸ������ �Ѵ�.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "����"),
        @ApiResponse(code = 401, message = "���� ����"),
        @ApiResponse(code = 404, message = "����� ����"),
        @ApiResponse(code = 500, message = "���� ����")
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@RequestBody @ApiParam(value="ȸ������ ����", required = true) UserRegisterPostReq registerInfo) {
		
		//���Ƿ� ���ϵ� User �ν��Ͻ�. ���� �ڵ�� ȸ�� ���� ���� ���θ� �Ǵ��ϱ� ������ ���� Insert �� ���� ������ �������� ����.
		User user = userService.createUser(registerInfo);
		
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
}
