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
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;
import io.swagger.annotations.ApiResponse;

/**
 * ÀÎÁõ °ü·Ã API ¿äÃ» Ã³¸®¸¦ À§ÇÑ ÄÁÆ®·Ñ·¯ Á¤ÀÇ.
 */
<<<<<<< HEAD
@Api(value = "ÀÎÁõ API", tags = {"Auth."})
=======
@Api(value = "ì¸ì¦ API", tags = {"Auth"})
>>>>>>> develop
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
	@ApiOperation(value = "·Î±×ÀÎ", notes = "<strong>¾ÆÀÌµğ¿Í ÆĞ½º¿öµå</strong>¸¦ ÅëÇØ ·Î±×ÀÎ ÇÑ´Ù.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "¼º°ø", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "¼­¹ö ¿À·ù", response = BaseResponseBody.class)
    })
	public ResponseEntity<UserLoginPostRes> login(@RequestBody @ApiParam(value="·Î±×ÀÎ Á¤º¸", required = true) UserLoginPostReq loginInfo) {
		String email = loginInfo.getEmail();
		String password = loginInfo.getPassword();
		
		//ÀÌ¸ŞÀÏ·Î ¼öÁ¤
		User user = userService.getUserByEmail(email);
<<<<<<< HEAD
		// ·Î±×ÀÎ ¿äÃ»ÇÑ À¯Àú·ÎºÎÅÍ ÀÔ·ÂµÈ ÆĞ½º¿öµå ¿Í µğºñ¿¡ ÀúÀåµÈ À¯ÀúÀÇ ¾ÏÈ£È­µÈ ÆĞ½º¿öµå°¡ °°ÀºÁö È®ÀÎ.(À¯È¿ÇÑ ÆĞ½º¿öµåÀÎÁö ¿©ºÎ È®ÀÎ)
=======
		Profile profile = profileService.getProfileByUserId(user.getUserId());
		/*
		 * íƒˆí‡´í•œ íšŒì›(user status ê°€ 1ì¼ë•Œ)ì¸ ê²½ìš° ë¡œê·¸ì¸ ì—ëŸ¬
		 */
		if(user.getUserStatus() == 1)
			return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "íƒˆí‡´í•œ íšŒì›ì…ë‹ˆë‹¤.", null));

		// ë¡œê·¸ì¸ ìš”ì²­í•œ ìœ ì €ë¡œë¶€í„° ì…ë ¥ëœ íŒ¨ìŠ¤ì›Œë“œ ì™€ ë””ë¹„ì— ì €ì¥ëœ ìœ ì €ì˜ ì•”í˜¸í™”ëœ íŒ¨ìŠ¤ì›Œë“œê°€ ê°™ì€ì§€ í™•ì¸.(ìœ íš¨í•œ íŒ¨ìŠ¤ì›Œë“œì¸ì§€ ì—¬ë¶€ í™•ì¸)
>>>>>>> develop
		if(passwordEncoder.matches(password, user.getPassword())) {
			// À¯È¿ÇÑ ÆĞ½º¿öµå°¡ ¸Â´Â °æ¿ì, ·Î±×ÀÎ ¼º°øÀ¸·Î ÀÀ´ä.(¾×¼¼½º ÅäÅ«À» Æ÷ÇÔÇÏ¿© ÀÀ´ä°ª Àü´Ş)
			return ResponseEntity.ok(UserLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(email)));
		}
		// À¯È¿ÇÏÁö ¾Ê´Â ÆĞ½º¿öµåÀÎ °æ¿ì, ·Î±×ÀÎ ½ÇÆĞ·Î ÀÀ´ä.
		return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "Invalid Password", null));
	}
	
	@PostMapping("/signup")
	@ApiOperation(value = "È¸¿ø °¡ÀÔ", notes = "<strong>¾ÆÀÌµğ¿Í ÆĞ½º¿öµå</strong>¸¦ ÅëÇØ È¸¿ø°¡ÀÔ ÇÑ´Ù.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "¼º°ø"),
        @ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
        @ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"),
        @ApiResponse(code = 500, message = "¼­¹ö ¿À·ù")
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@RequestBody @ApiParam(value="È¸¿ø°¡ÀÔ Á¤º¸", required = true) UserRegisterPostReq registerInfo) {
		
		//ÀÓÀÇ·Î ¸®ÅÏµÈ User ÀÎ½ºÅÏ½º. ÇöÀç ÄÚµå´Â È¸¿ø °¡ÀÔ ¼º°ø ¿©ºÎ¸¸ ÆÇ´ÜÇÏ±â ¶§¹®¿¡ ±»ÀÌ Insert µÈ À¯Àú Á¤º¸¸¦ ÀÀ´äÇÏÁö ¾ÊÀ½.
		User user = userService.createUser(registerInfo);
		
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	/*
	 * ·Î±×¾Æ¿ô ±¸Çö
	 * 
	 */
//	@GetMapping("/logout")
//	@ApiOperation(value = "ÀÌ¸ŞÀÏ Áßº¹ È®ÀÎ", notes = "È¸¿ø°¡ÀÔ Áß ÀÌ¸ŞÀÏ Áßº¹È®ÀÎ") 
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "¼º°ø"),
//        @ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
//        @ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"),
//        @ApiResponse(code = 500, message = "¼­¹ö ¿À·ù")
//    })
//	public void logout(HttpServletRequest request) {
//        UserLoginPostRes.of(200, "success", null);
//    }	
//	
	/*
	 * ÀÌ¸ŞÀÏ Áßº¹ È®ÀÎ
	 * 
	 */
	@GetMapping("/checkEmail/{email}")
	@ApiOperation(value = "ÀÌ¸ŞÀÏ Áßº¹ È®ÀÎ", notes = "È¸¿ø°¡ÀÔ Áß ÀÌ¸ŞÀÏ Áßº¹È®ÀÎ") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "¼º°ø"),
        @ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
        @ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"),
        @ApiResponse(code = 500, message = "¼­¹ö ¿À·ù")
    })
	public ResponseEntity<Boolean> checkEmail(@PathVariable String email) {
		System.out.println(email);
		return ResponseEntity.ok(userService.checkEmail(email));
	}
	
	/*
	 * À¯Àú³×ÀÓ Áßº¹ È®ÀÎ
	 * 
	 */
	@GetMapping("/checkNickname/{nickname}")
	@ApiOperation(value = "´Ğ³×ÀÓ Áßº¹ È®ÀÎ", notes = "È¸¿ø°¡ÀÔ Áß ´Ğ³×ÀÓ Áßº¹È®ÀÎ") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "¼º°ø"),
        @ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
        @ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"),
        @ApiResponse(code = 500, message = "¼­¹ö ¿À·ù")
    })
	public ResponseEntity<Boolean> checkUsername(@PathVariable String nickname) {
		return ResponseEntity.ok(profileService.checkName(nickname));
	}
	
	/*
	 * ºñ¹Ğ¹øÈ£ ¼öÁ¤	=> ÀÌ¸ŞÀÏ ÀÎÁõ ÈÄ¿¡.
	 * 
	 */
//	@PutMapping("/password")
//	@ApiOperation(value = "ºñ¹Ğ¹øÈ£ ¼öÁ¤", notes = "ÇöÀç ºñ¹Ğ¹øÈ£¸¦ ¼öÁ¤ÇÕ´Ï´Ù.") 
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "¼º°ø"),
//        @ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
//        @ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"),
//        @ApiResponse(code = 500, message = "¼­¹ö ¿À·ù")
//    })
//	public ResponseEntity<Boolean> modifyPassword(@PathVariable String newPassword){
//		User user = userService.getU
//	}
	
	/*	
	 * È¸¿ø»èÁ¦	=> profile¿¡¼­ »ç¿ëµÇ´Â user_status º¯°æ
	 * 
	 */
	@PutMapping("/delete")
	@ApiOperation(value = "È¸¿ø Å»Åğ Ã³¸®", notes = "È¸¿øÀÇ »óÅÂ¸¦ Å»Åğ»óÅÂ·Î º¯°æÇÕ´Ï´Ù.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "¼º°ø"),
        @ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
        @ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"),
        @ApiResponse(code = 500, message = "¼­¹ö ¿À·ù")
    })
	public ResponseEntity<Boolean> changeStatus(@ApiIgnore Authentication authentication, @RequestParam String password){
		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
		String email = userDetails.getEmail();
		String userPw = userDetails.getPassword();
		
//		if(email.equals(password))
//			return ResponseEntity.ok(userService.changeStatus(email, userPw);)
//		else
//			return ResponseEntity.ok(userService.changeStatus(email, userPw);)
//			
		return ResponseEntity.ok(true);
		//³» Á¤º¸¿¡¼­ °¡Á®¿Â ºñ¹Ğ¹øÈ£°¡ ÀÎÄÚµù µÇ¾îÀÖÀ» °æ¿ì
		/*
		 * email.equals(passwordEncoder.encode(password))
		 */
		
//		boolean result = userService.checkPw(password);
//		if(result) {
//			userService.changeStatus(u)
//		}
		//return null;
	}
}
