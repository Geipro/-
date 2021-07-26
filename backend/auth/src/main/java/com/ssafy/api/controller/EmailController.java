package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.service.EmailService;
import com.ssafy.api.service.EmailServiceImpl;

import io.swagger.annotations.Api;

@Api(value = "∏ﬁ¿œ API", tags = {"Email."})
@RestController
@RequestMapping("api/email")
public class EmailController {
	
	@Autowired
	EmailService mailService;
		
	@ResponseBody
	public int verifyCode(String code) {
		//logger.info("Post verifyCode");
		
		int result = 0;
		System.out.println("code : "+code);
		System.out.println("code match : "+ EmailServiceImpl.ePw.equals(code));
		if(EmailServiceImpl.ePw.equals(code)) {
			result =1;
		}
		
		return result;
	}
}
