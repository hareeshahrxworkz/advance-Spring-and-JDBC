package com.xworkz.hotel.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.hotel.dto.CMDTO;
import com.xworkz.hotel.service.CMService;

@Controller
@RequestMapping("/cm")
public class CMController {
	@Autowired
	private CMService cmService;
@PostMapping
	public String oncmcontrollor(CMDTO cmdto) {

		System.out.println("Controller Running");
		Set<ConstraintViolation<CMDTO>> constraintViolations = cmService.ValidateAndSave(cmdto);
		if (!constraintViolations.isEmpty()) {
			System.out.println("is not empty validation error");
			constraintViolations.forEach(e -> System.out.println(e.getMessage()));

		}

		return "Display";
	}

}
