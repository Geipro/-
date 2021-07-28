package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.service.EmailService;
import com.ssafy.api.service.EmailServiceImpl;
import com.ssafy.api.service.UserService;
import com.ssafy.db.repository.UserRepository;

import io.swagger.annotations.Api;

@Api(value = "이메일 인증 API", tags = {"Email"})
@RestController
@RequestMapping("api/emailAuth")
public class EmailController {
	
	@Autowired
	EmailService mailService;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/send/{mail}")
	@ResponseBody
	public boolean emailConfirm(@PathVariable String mail) throws Exception{
		if(userRepository.existsByEmail(mail)) {
			System.out.println("전달 받은 이메일 : " + mail);
			mailService.sendSimpleMessage(mail);
			
			return true;
		}else		//저장된 이메일이 아닌 경우.
			return false;
	}
		
	@PostMapping("/check/verifying")
	@ResponseBody
	public boolean verifyCode(String code) {
		//logger.info("Post verifyCode");
		
		boolean result = false;
		System.out.println("code : "+code);
		System.out.println("code match : "+ EmailServiceImpl.ePw.equals(code));
		if(EmailServiceImpl.ePw.equals(code)) {
			result = true;
		}
		
		return result;
	}
}
