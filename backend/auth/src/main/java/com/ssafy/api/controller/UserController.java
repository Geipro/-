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
import com.ssafy.api.service.ProfileService;
import com.ssafy.api.service.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.Profile;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepositorySupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 유저 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "유저 API", tags = { "User" })
@RestController
@RequestMapping("/api/profile")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProfileService profileService;

	@GetMapping("/inquire")
	@ApiOperation(value = "회원 본인 정보 조회", notes = "로그인한 회원 본인의 정보를 응답한다.")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "성공"), 
		@ApiResponse(code = 401, message = "인증 실패"),
		@ApiResponse(code = 404, message = "사용자 없음"), 
		@ApiResponse(code = 500, message = "서버 오류") 
	})
	public ResponseEntity<UserRes> getMyInfo(@ApiIgnore Authentication authentication) {
		/**
		 * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저
		 * 식별. 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access
		 * Denied"}) 발생.
		 */
		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
		String email = userDetails.getEmail();
		System.out.println("email = " + email);
		String nickname = userDetails.getUsername();
		System.out.println("nickname" + nickname);
		User user = userService.getUserByEmail(email);
		Profile profile = profileService.getUserByNickname(nickname);
		return ResponseEntity.status(200).body(UserRes.of(profile));
	}
	
	@GetMapping("/{nickname}")
	@ApiOperation(value = "회원 정보 조회", notes = "검색한 회원의 정보를 응답한다.")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "성공"), 
		@ApiResponse(code = 401, message = "인증 실패"),
		@ApiResponse(code = 404, message = "사용자 없음"), 
		@ApiResponse(code = 500, message = "서버 오류") 
	})
	public ResponseEntity<UserRes> getUserInfo(@PathVariable String nickname) {
		/* 수정필요 */
		//User user = userService.getUserByNickname(nickname);
		Profile profile = profileService.getUserByNickname(nickname);
		return ResponseEntity.status(200).body(UserRes.of(profile));
	}

	
//	@GetMapping("/settings")
//	@ApiOperation(value = "환경설정 셋팅", notes = "환경설정을 설정합니다.")
//	@ApiResponses({ 
//		@ApiResponse(code = 200, message = "성공"), 
//		@ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "사용자 없음"), 
//		@ApiResponse(code = 500, message = "서버 오류") 
//	})
//	public ResponseEntity<UserRes>
}
