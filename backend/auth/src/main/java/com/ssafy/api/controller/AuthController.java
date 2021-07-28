package com.ssafy.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserLoginPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.service.ProfileService;
import com.ssafy.api.service.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.Profile;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;
import io.swagger.annotations.ApiResponse;

/**
 * 인증 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "인증 API", tags = {"Auth."})
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
	@ApiOperation(value = "로그인", notes = "<strong>아이디와 패스워드</strong>를 통해 로그인 한다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
	public ResponseEntity<UserLoginPostRes> login(@RequestBody @ApiParam(value="로그인 정보", required = true) UserLoginPostReq loginInfo) {
		String email = loginInfo.getEmail();
		String password = loginInfo.getPassword();
		
		//이메일로 수정
		User user = userService.getUserByEmail(email);
		Profile profile = profileService.getUserByUserId(user.getUserId());
		/*
		 * 탈퇴한 회원(user status 가 1일때)인 경우 로그인 에러
		 */
		if(user.getUserStatus() == 1)
			return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "탈퇴한 회원입니다.", null));

		// 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
		if(passwordEncoder.matches(password, user.getPassword())) {
			// 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
			return ResponseEntity.ok(UserLoginPostRes.of(200, profile.getNickname(), JwtTokenUtil.getToken(email)));
		}
		// 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
		return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "Invalid Password", null));
	}
	
	@PostMapping("/signup")
	@ApiOperation(value = "회원 가입", notes = "<strong>아이디와 패스워드</strong>를 통해 회원가입 한다.") 
	@ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@RequestBody @ApiParam(value="회원가입 정보", required = true) UserRegisterPostReq registerInfo) {
		
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
		User user = userService.createUser(registerInfo);
		
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	/*
	 * 로그아웃
	 * 
	 */
//	@GetMapping("/logout")
//	@ApiResponses({
//    @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
//    @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
//    @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
//    @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
//})
//	public void logout(HttpServletRequest request) {
//        UserLoginPostRes.of(200, "success", null);
//    }	
//	
	/*
	 * 이메일 중복 확인
	 * 
	 */
	@GetMapping("/checkEmail/{email}")
	@ApiOperation(value = "이메일 중복 확인", notes = "회원가입 중 이메일 중복확인") 
	@ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
	public ResponseEntity<Boolean> checkEmail(@PathVariable String email) {
		System.out.println(email);
		return ResponseEntity.ok(userService.checkEmail(email));
	}
	
	/*
	 * 유저네임 중복 확인
	 * 
	 */
	@GetMapping("/checkNickname/{nickname}")
	@ApiOperation(value = "닉네임 중복 확인", notes = "회원가입 중 닉네임 중복확인") 
	@ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
	public ResponseEntity<Boolean> checkUsername(@PathVariable String nickname) {
		return ResponseEntity.ok(profileService.checkName(nickname));
	}
	
	/*
	 * 비밀번호 수정	=> 이메일 인증 후에. 이멜인증은 EmailController에서 보내고 인증까지.
	 * 인증 한 후에 새로운 비밀번호 등록하는 페이지.
	 * 이메일도 인자로 받아야겟지?
	 * 
	 */
	@PutMapping("/changePw")
	@ApiOperation(value = "비밀번호 수정", notes = "현재 비밀번호를 수정합니다.") 
	@ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
	public ResponseEntity<Boolean> modifyPassword(@RequestBody @ApiParam(value="로그인 정보", required = true) UserLoginPostReq loginInfo){
		//기존 로그인과 같이 바꾸고자 하는 이메일과 새로운 비밀번호가 들어올 것.
		String email = loginInfo.getEmail();
		String newPw = loginInfo.getPassword();
		
		return ResponseEntity.ok(userService.changePw(email, newPw));
	}
	
	/*	
	 *회원삭제	=> profile에서 사용되는 user_status 변경
	 * 
	 */
	@PutMapping("/delete")
	@ApiOperation(value = "회원 탈퇴 처리", notes = "회원의 상태를 탈퇴상태로 변경합니다.") 
	@ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
	public ResponseEntity<Boolean> changeStatus(@RequestParam String password, @ApiIgnore Authentication authentication){
		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
		String email = userDetails.getEmail();
		String userPw = userDetails.getPassword();
		
		/*
		 * 가져온 비밀번호가 인코딩 되어있는 경우가 아닐 때
		 */
		if(userPw.length() < 20) {
			if(userPw.equals(password))
				return ResponseEntity.ok(userService.changeStatus(email, userPw));
			else
				return ResponseEntity.ok(false);
		}else {
		/*
		 * 내 정보에서 가져온 비밀번호가 인코딩 되어있을 경우
		 */
			if(userPw.equals(passwordEncoder.encode(password)))
				return ResponseEntity.ok(userService.changeStatus(email, userPw));
			else
				return ResponseEntity.ok(false);
		}
	}
}
