package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserLoginPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.response.UserRes;
import com.ssafy.api.service.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepositorySupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * ���� ���� API ��û ó���� ���� ��Ʈ�ѷ� ����.
 */
@Api(value = "���� API", tags = { "User" })
@RestController
@RequestMapping("/api/profile")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/inquire")
	@ApiOperation(value = "ȸ�� ���� ���� ��ȸ", notes = "�α����� ȸ�� ������ ������ �����Ѵ�.")
	@ApiResponses({ @ApiResponse(code = 200, message = "����"), @ApiResponse(code = 401, message = "���� ����"),
			@ApiResponse(code = 404, message = "����� ����"), @ApiResponse(code = 500, message = "���� ����") })
	public ResponseEntity<UserRes> getMyInfo(@ApiIgnore Authentication authentication) {
		/**
		 * ��û ��� �׼��� ��ū�� ���Ե� ��쿡�� ����Ǵ� ���� ó������, ���ϵǴ� ���� ���� ��ü(authentication) ���ؼ� ��û�� ����
		 * �ĺ�. �׼��� ��ū�� ���� ��û�ϴ� ���, 403 ����({"error": "Forbidden", "message": "Access
		 * Denied"}) �߻�.
		 */
		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
		String userId = userDetails.getUsername();
		User user = userService.getUserByUserId(userId);

		return ResponseEntity.status(200).body(UserRes.of(user));
	}
	
	@GetMapping("/{username}")
	@ApiOperation(value = "ȸ�� ���� ��ȸ", notes = "�˻��� ȸ���� ������ �����Ѵ�.")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "����"), 
		@ApiResponse(code = 401, message = "���� ����"),
		@ApiResponse(code = 404, message = "����� ����"), 
		@ApiResponse(code = 500, message = "���� ����") 
	})
	public ResponseEntity<UserRes> getUserInfo(@PathVariable String username) {
//		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
//		String userId = userDetails.getUsername();
		User user = userService.getUserByUserId(username);

		return ResponseEntity.status(200).body(UserRes.of(user));
	}

	
//	@GetMapping("/settings")
//	@ApiOperation(value = "ȯ�漳�� ��ȸ", notes = "������ ȯ�漳�� ������ �ҷ��´�")
//	@ApiResponses({
//		@ApiResponse(code = 200, message = "����"),
//		@ApiResponse(code = 401, message = "���� ����"),
//		@ApiResponse(code = 404, message = "����� ����"),
//		@ApiResponse(code = 500, message = "���� ����") }) 
//	public ResponseEntity<UserRes>
}
