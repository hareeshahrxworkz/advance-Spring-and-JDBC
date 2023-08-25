package com.xworkz.email.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.xworkz.email.dto.EmailDTO;
import com.xworkz.email.entity.EmailEntity;
import com.xworkz.email.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository emailRepository;

	public EmailServiceImpl() {
		System.out.println("Running" + getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<EmailDTO>> ValidateAndSave(EmailDTO dto) {
		System.out.println("Running Validation");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<EmailDTO>> violations = factory.getValidator().validate(dto);
		if (violations.isEmpty()) {
			System.out.println("voialation is not there please proceed saving process");
			EmailEntity entity = new EmailEntity();
//			entity.setId(dto.getId());

			System.out.println(dto);

			entity.setEmail(dto.getEmail());
			entity.setFName(dto.getFName());
			entity.setLname(dto.getLname());
			entity.setId(dto.getId());
			entity.setMobileNo(dto.getMobileNo());

			boolean save = emailRepository.save(entity);
			System.out.println(entity);
			System.out.println(save);
			return Collections.emptySet();

		} else {
			System.out.println("voilation is there ");
			return violations;
		}
	}

	@Override
	public boolean sendEmail(EmailDTO dto, String email) {

		System.out.println("running sendMail in ProjectServiceImpl.........");

		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "hareesharaju@outlook.com";
		String password = "9900775088Hr@";
		String to = email;

		Properties prop = System.getProperties();
		System.out.println("properties" + prop);
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocal", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("your otp");
			String randomText = this.RandomOtp();

			message.setText(randomText);

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			System.out.println("mail sent successfully");
			List<EmailEntity> entities = emailRepository.byEmail(email);
			for (EmailEntity entity : entities) {

				if (entity.getEmail().equalsIgnoreCase(email)) {
					entity.setOtp(randomText);
					System.out.println("====================================================================");
					System.out.println(entity.getFName());
					System.out.println(entity.getFName());

					boolean save = emailRepository.onUpdate(entity);

				}

			}

			System.out.println("otp update sucessfully");
			return true;

		}

		catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<EmailDTO> byEmail(String mail) {

		List<EmailEntity> lists = emailRepository.byEmail(mail);

		if (lists != null && !lists.isEmpty()) {
			List<EmailDTO> dtos = new ArrayList<EmailDTO>();
			for (EmailEntity entity : lists) {
				System.out.println(entity);
				EmailDTO dto = new EmailDTO();
				dto.setId(entity.getId());
				dto.setEmail(entity.getEmail());
				dto.setFName(entity.getFName());
				dto.setLname(entity.getLname());
				dto.setId(entity.getId());
				dto.setMobileNo(entity.getMobileNo());
				dtos.add(dto);
			}
			return dtos;

		} else {
			System.out.println("Dto is nulll");
			return EmailService.super.byEmail(mail);

		}

	}

	public static String RandomOtp() {
		System.out.println("Generate OTP (One Time Password),");
		int randomNo = (int) (Math.random() * 9000) + 1000;
		String otp = String.valueOf(randomNo);
		System.out.println("4 digits OTP: " + otp);
		return otp;
	}

}
