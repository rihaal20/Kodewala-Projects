package com.railone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railone.request.OtpRequest;
import com.railone.service.OtpService;

@RestController
@RequestMapping("otp")
public class OtpController
{
	
	@Autowired
	OtpService otpService;

	@PostMapping("/generate")
	public String generateOtp(@RequestBody OtpRequest otpRequest)
	{
		String name=otpRequest.getMobile();
		String mobile=otpRequest.getName();
		int otp=otpService.saveOtp(name, mobile);
		return "Your otp is: " +otp;

		}
	
}
