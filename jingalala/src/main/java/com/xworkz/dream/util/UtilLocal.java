package com.xworkz.dream.util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class UtilLocal implements DreamUtil{

	@Value("${mail.smtpHost}")
	private String smtpHost;
	@Value("${mail.smtpPort}")
	private int smtpPort;
	@Value("${mail.userName}")
	private String userName;
	@Value("${mail.password}")
	private String password;
	

	private static final Logger logger = LoggerFactory.getLogger(UtilLocal.class);


    @Profile("local")
    @Override
    public boolean sendOtptoEmail(String email, int otp) {
        logger.debug("Sending local mail to {}", email);
        return true;
    }
    

	@Profile("local")
    @Override
	public  int generateOTP() {
	System.out.println("Local Otp");
	return 123456;
	}
	
	
	@Override
	public  String generateToken() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] tokenBytes = new byte[32];
		secureRandom.nextBytes(tokenBytes);
		return Base64.getEncoder().encodeToString(tokenBytes);
	}


	@Override
	public boolean sendCourseContent(String email, String name) {
		// TODO Auto-generated method stub
		return false;
	}
    

}
