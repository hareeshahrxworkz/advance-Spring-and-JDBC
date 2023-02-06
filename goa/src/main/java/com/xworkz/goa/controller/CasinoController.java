package com.xworkz.goa.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.goa.chat.Casinochat;

@Component
@RequestMapping("/casino")
public class CasinoController {
	public CasinoController() {
		System.out.println("Running : " + getClass().getSimpleName());
	}

	@PostMapping
	public String casinoController(Casinochat casinochat, Model model) {
		System.out.println("Running Casino" + casinochat);
		model.addAttribute("name", casinochat.getName());
		model.addAttribute("cruise", casinochat.getCruise());
		model.addAttribute("food", casinochat.getFood());
		model.addAttribute("alcohal", casinochat.getAlcohol());
		model.addAttribute("fee", casinochat.getFee());

		return "CasinoSucess.jsp";

	}

}
