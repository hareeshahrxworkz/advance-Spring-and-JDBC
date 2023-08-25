package com.xworkz.email.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.email.dto.EmailDTO;
import com.xworkz.email.entity.EmailEntity;
import com.xworkz.email.repository.EmailRepository;
import com.xworkz.email.service.EmailService;

@Controller
@RequestMapping("/")
public class EmailController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmailRepository emailRepository;

	public EmailController() {
		System.out.println("Running" + getClass().getSimpleName());
	}

	@GetMapping("validOtp")
	public String validateOtp(Model model, @RequestParam String otp) {
//		if (mail.getOtp().equalsIgnoreCase(otp)) {
//			model.addAttribute("lists", list);
//			System.out.println("Running otp validation");
//
//			return "home";
		return "home";
	}

	@PostMapping("email")
	public String postOtp(Model model, @RequestParam String email, EmailDTO dto) {
		System.out.println("Running post otp");
		List<EmailDTO> list = emailService.byEmail(email);

		for (EmailDTO mail : list) {

			if (mail.getEmail().equalsIgnoreCase(email)) {
				System.out.println("Comparing Sucess");
				model.addAttribute("email", mail.getEmail());

//				emailService.sendEmail(dto, email);
				return "index";

			}

			else {

				System.out.println("Data is not exists");
				model.addAttribute("invalid", "email Does Not Exists");
				return "index";
			}

		}
		return "index";

	}

	@GetMapping("register")
	public String getMailDetiles(Model model, EmailDTO dto) {
		System.out.println("Running registet mail");

		return "register";
	}

	@GetMapping("index")
	public String getMailDetiles() {
		System.out.println("Running registet mail");

		return "index";
	}

	@PostMapping("emailRegister")

	public String GetMailDetiles(Model model, EmailDTO dto) {
		System.out.println("Running register");

		Set<ConstraintViolation<EmailDTO>> violations = emailService.ValidateAndSave(dto);

		if (violations.isEmpty()) {
			System.out.println("Vilation is not there saving process running");
			model.addAttribute("sucess", "Email Registration Sussfully");

			return "register";

		} else {

			System.out.println("voilation is there ");
			model.addAttribute("error", violations);
			return "register";

		}

	}
}
