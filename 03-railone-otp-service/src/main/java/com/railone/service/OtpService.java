package com.railone.service;

import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.railone.entity.OtpEntity;
import com.railone.repository.OtpRepository;

@Service
public class OtpService {

	@Autowired
	OtpRepository otpRepository;
	
	public int saveOtp(String name, String mobile)
	{
		OtpEntity otpEntity= new OtpEntity();
		otpEntity.setOtp(generateOtp());
		otpEntity.setStatus("Active");
		OtpEntity response= otpRepository.save(otpEntity);
		if(response.getId()>0)
		{
			System.out.println("Otp saved successfully");
		}
		else
		{
			System.out.println("Unable to save otp");
		}
		return response.getOtp();
	}
	private int generateOtp()
	{
		SecureRandom random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000); // Generates 100000 to 999999
		System.out.println(" Generated OTP :::: " + otp);
		return otp;
	}
}
