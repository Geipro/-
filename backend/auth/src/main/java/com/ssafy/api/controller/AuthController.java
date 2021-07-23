package com.ssafy.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserLoginPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.service.ProfileService;
import com.ssafy.api.service.UserService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.User;

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
	ProfileService profileService;
	
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
		String email = loginInfo.getEmail();
		String password = loginInfo.getPassword();
		
		//�̸��Ϸ� ����
		User user = userService.getUserByEmail(email);
		// �α��� ��û�� �����κ��� �Էµ� �н����� �� ��� ����� ������ ��ȣȭ�� �н����尡 ������ Ȯ��.(��ȿ�� �н��������� ���� Ȯ��)
		if(passwordEncoder.matches(password, user.getPassword())) {
			// ��ȿ�� �н����尡 �´� ���, �α��� �������� ����.(�׼��� ��ū�� �����Ͽ� ���䰪 ����)
			return ResponseEntity.ok(UserLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(email)));
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
	
	/*
	 * �α׾ƿ� ����
	 * 
	 */
//	@GetMapping("/logout")
//	@ApiOperation(value = "�̸��� �ߺ� Ȯ��", notes = "ȸ������ �� �̸��� �ߺ�Ȯ��") 
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "����"),
//        @ApiResponse(code = 401, message = "���� ����"),
//        @ApiResponse(code = 404, message = "����� ����"),
//        @ApiResponse(code = 500, message = "���� ����")
//    })
//	public void logout(HttpServletRequest request) {
//        UserLoginPostRes.of(200, "success", null);
//    }	
//	
	/*
	 * �̸��� �ߺ� Ȯ��
	 * 
	 */
	@GetMapping("/email")
	@ApiOperation(value = "�̸��� �ߺ� Ȯ��", notes = "ȸ������ �� �̸��� �ߺ�Ȯ��") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "����"),
        @ApiResponse(code = 401, message = "���� ����"),
        @ApiResponse(code = 404, message = "����� ����"),
        @ApiResponse(code = 500, message = "���� ����")
    })
	public ResponseEntity<Boolean> checkEmail(@PathVariable String email) {
		return ResponseEntity.ok(userService.checkEmail(email));
	}
	
	/*
	 * �������� �ߺ� Ȯ��
	 * 
	 */
	@GetMapping("/nickname")
	@ApiOperation(value = "�г��� �ߺ� Ȯ��", notes = "ȸ������ �� �г��� �ߺ�Ȯ��") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "����"),
        @ApiResponse(code = 401, message = "���� ����"),
        @ApiResponse(code = 404, message = "����� ����"),
        @ApiResponse(code = 500, message = "���� ����")
    })
	public ResponseEntity<Boolean> checkUsername(@PathVariable String nickname) {
		return ResponseEntity.ok(profileService.checkName(nickname));
	}
	
	/*
	 * ��й�ȣ ����	=> �̸��� ���� �Ŀ�.
	 * 
	 */
//	@PutMapping("/password")
//	@ApiOperation(value = "��й�ȣ ����", notes = "���� ��й�ȣ�� �����մϴ�.") 
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "����"),
//        @ApiResponse(code = 401, message = "���� ����"),
//        @ApiResponse(code = 404, message = "����� ����"),
//        @ApiResponse(code = 500, message = "���� ����")
//    })
//	public ResponseEntity<Boolean> modifyPassword(@PathVariable String newPassword){
//		User user = userService.getU
//	}
	
	/*	
	 * ȸ������	=> proifle���� ���Ǵ� user_status ����
	 * 
	 */
//	@PutMapping("/delete")
//	@ApiOperation(value = "ȸ�� Ż�� ó��", notes = "ȸ���� ���¸� Ż����·� �����մϴ�.") 
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "����"),
//        @ApiResponse(code = 401, message = "���� ����"),
//        @ApiResponse(code = 404, message = "����� ����"),
//        @ApiResponse(code = 500, message = "���� ����")
//    })
//	public ResponseEntity<Boolean> statusChange(@PathVariable String password){
//		
//	}
}
