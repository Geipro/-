package com.ssafy.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserLoginPostReq;
import com.ssafy.api.request.UserModifyInfoReq;
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
 * À¯Àú °ü·Ã API ¿äÃ» Ã³¸®¸¦ À§ÇÑ ÄÁÆ®·Ñ·¯ Á¤ÀÇ.
 */
@Api(value = "À¯Àú API", tags = { "User" })
@RestController
@RequestMapping("/api/profile")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ProfileService profileService;

<<<<<<< HEAD
	@GetMapping("/inquire")
	@ApiOperation(value = "È¸¿ø º»ÀÎ Á¤º¸ Á¶È¸", notes = "·Î±×ÀÎÇÑ È¸¿ø º»ÀÎÀÇ Á¤º¸¸¦ ÀÀ´äÇÑ´Ù.")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "¼º°ø"), 
		@ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
		@ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"), 
		@ApiResponse(code = 500, message = "¼­¹ö ¿À·ù") 
	})
	public ResponseEntity<UserRes> getMyInfo(@ApiIgnore Authentication authentication) {
		/**
		 * ¿äÃ» Çì´õ ¾×¼¼½º ÅäÅ«ÀÌ Æ÷ÇÔµÈ °æ¿ì¿¡¸¸ ½ÇÇàµÇ´Â ÀÎÁõ Ã³¸®ÀÌÈÄ, ¸®ÅÏµÇ´Â ÀÎÁõ Á¤º¸ °´Ã¼(authentication) ÅëÇØ¼­ ¿äÃ»ÇÑ À¯Àú
		 * ½Äº°. ¾×¼¼½º ÅäÅ«ÀÌ ¾øÀÌ ¿äÃ»ÇÏ´Â °æ¿ì, 403 ¿¡·¯({"error": "Forbidden", "message": "Access
		 * Denied"}) ¹ß»ı.
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
	@ApiOperation(value = "È¸¿ø Á¤º¸ Á¶È¸", notes = "°Ë»öÇÑ È¸¿øÀÇ Á¤º¸¸¦ ÀÀ´äÇÑ´Ù.")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "¼º°ø"), 
		@ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
		@ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"), 
		@ApiResponse(code = 500, message = "¼­¹ö ¿À·ù") 
	})
	public ResponseEntity<UserRes> getUserInfo(@PathVariable String nickname) {
		/* ¼öÁ¤ÇÊ¿ä */
		//User user = userService.getUserByNickname(nickname);
		Profile profile = profileService.getUserByNickname(nickname);
=======
	/*
	 * @GetMapping("/inquire")
	 * 
	 * @ApiOperation(value = "íšŒì› ë³¸ì¸ ì •ë³´ ì¡°íšŒ", notes = "ë¡œê·¸ì¸í•œ íšŒì› ë³¸ì¸ì˜ ì •ë³´ë¥¼ ì‘ë‹µí•œë‹¤.")
	 * 
	 * @ApiResponses({
	 * 
	 * @ApiResponse(code = 200, message = "ì„±ê³µ"),
	 * 
	 * @ApiResponse(code = 401, message = "ì¸ì¦ ì‹¤íŒ¨"),
	 * 
	 * @ApiResponse(code = 404, message = "ì‚¬ìš©ì ì—†ìŒ"),
	 * 
	 * @ApiResponse(code = 500, message = "ì„œë²„ ì˜¤ë¥˜") }) public ResponseEntity<UserRes>
	 * getMyInfo(@ApiIgnore Authentication authentication) {
	 *//**
		 * ìš”ì²­ í—¤ë” ì•¡ì„¸ìŠ¤ í† í°ì´ í¬í•¨ëœ ê²½ìš°ì—ë§Œ ì‹¤í–‰ë˜ëŠ” ì¸ì¦ ì²˜ë¦¬ì´í›„, ë¦¬í„´ë˜ëŠ” ì¸ì¦ ì •ë³´ ê°ì²´(authentication) í†µí•´ì„œ ìš”ì²­í•œ ìœ ì €
		 * ì‹ë³„. ì•¡ì„¸ìŠ¤ í† í°ì´ ì—†ì´ ìš”ì²­í•˜ëŠ” ê²½ìš°, 403 ì—ëŸ¬({"error": "Forbidden", "message":
		 * "AccessDenied"}) ë°œìƒ.
		 *//*
			 * SsafyUserDetails userDetails = (SsafyUserDetails)
			 * authentication.getDetails(); String email = userDetails.getEmail(); String
			 * userId = userDetails.getUserId(); System.out.println("email = " + email);
			 * 
			 * // User user = userService.getUserByEmail(email); Profile profile =
			 * profileService.getUserByUserId(userId); String nickname =
			 * profile.getNickname(); System.out.println("nickname" + nickname);
			 * 
			 * //Profile profile = profileService.getUserByNickname(nickname); return
			 * ResponseEntity.status(200).body(UserRes.of(profile)); }
			 */

	@GetMapping("/{nickname}")
	@ApiOperation(value = "íšŒì› ì •ë³´ ì¡°íšŒ", notes = "ê²€ìƒ‰í•œ íšŒì›ì˜ ì •ë³´ë¥¼ ì‘ë‹µí•œë‹¤.")
	@ApiResponses({ @ApiResponse(code = 200, message = "ì„±ê³µ"), @ApiResponse(code = 401, message = "ì¸ì¦ ì‹¤íŒ¨"),
			@ApiResponse(code = 404, message = "ì‚¬ìš©ì ì—†ìŒ"), @ApiResponse(code = 500, message = "ì„œë²„ ì˜¤ë¥˜") })
	public ResponseEntity<UserRes> getUserInfo(@PathVariable String nickname) {
		/* ìˆ˜ì •í•„ìš” */
		// User user = userService.getUserByNickname(nickname);
		Profile profile = profileService.getProfileByNickname(nickname);
>>>>>>> develop
		return ResponseEntity.status(200).body(UserRes.of(profile));
	}

	@PutMapping("/modify")
	@ApiOperation(value = "íšŒì› ì •ë³´ ìˆ˜ì •", notes = "ë‚´ Profile ì •ë³´ë¥¼ ìˆ˜ì •í•˜ëŠ” í˜ì´ì§€.")
	@ApiResponses({ @ApiResponse(code = 200, message = "ì„±ê³µ"), @ApiResponse(code = 401, message = "ì¸ì¦ ì‹¤íŒ¨"),
			@ApiResponse(code = 404, message = "ì‚¬ìš©ì ì—†ìŒ"), @ApiResponse(code = 500, message = "ì„œë²„ ì˜¤ë¥˜") })
	public ResponseEntity<Boolean> modifyProfile(
			@RequestBody @ApiParam(value = "í”„ë¡œí•„ ì •ë³´ìˆ˜ì •", required = true) UserModifyInfoReq modifyInfo,
			@ApiIgnore Authentication authentication) {
		SsafyUserDetails userDetails = (SsafyUserDetails) authentication.getDetails();
		String userId = userDetails.getUserId();
		String nickname = modifyInfo.getNickname();
		String aboutMe = modifyInfo.getAboutMe();

		if (profileService.checkName(nickname)) {

			return ResponseEntity.ok(false);
		} else {
			profileService.changeProfileInfo(userId, nickname, aboutMe);
			return ResponseEntity.ok(true);
		}

	}

//	@GetMapping("/settings")
//	@ApiOperation(value = "È¯°æ¼³Á¤ Á¶È¸", notes = "º»ÀÎÀÇ È¯°æ¼³Á¤ ¼ÂÆÃÀ» ºÒ·¯¿Â´Ù")
//	@ApiResponses({
//		@ApiResponse(code = 200, message = "¼º°ø"),
//		@ApiResponse(code = 401, message = "ÀÎÁõ ½ÇÆĞ"),
//		@ApiResponse(code = 404, message = "»ç¿ëÀÚ ¾øÀ½"),
//		@ApiResponse(code = 500, message = "¼­¹ö ¿À·ù") }) 
//	public ResponseEntity<UserRes>
}
