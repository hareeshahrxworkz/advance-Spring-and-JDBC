package com.xworkz.goa.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.goa.dto.CasinoDTO;

@Component
@RequestMapping("/casino")
public class CasinoController {
	public CasinoController() {
		System.out.println("Running : " + getClass().getSimpleName());
	}

	@PostMapping
	public String casinoController(CasinoDTO casinoDTO, Model model) {
		System.out.println("Running Casino" + casinoDTO);
		model.addAttribute("name", casinoDTO.getName());
		model.addAttribute("cruise", casinoDTO.getCruise());
		model.addAttribute("food", casinoDTO.getFood());
		model.addAttribute("alcohal", casinoDTO.getAlcohol());
		model.addAttribute("fee", casinoDTO.getFee());

		return "CasinoSucess.jsp";

	}

}
