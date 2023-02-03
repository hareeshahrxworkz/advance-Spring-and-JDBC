package com.xworkz.goa.controller;

import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.goa.dto.BeachDTO;

@Component
@RequestMapping("/beach")
public class BeachController {
	public BeachController() {
		System.out.println("Running : " + getClass().getSimpleName());
	}

	@PostMapping
	public String beachController(BeachDTO beachDTO, Model model) {
		System.out.println("Running :" + beachDTO);
		model.addAttribute("name", beachDTO.getName());
		model.addAttribute("location", beachDTO.getLocation());
		model.addAttribute("clean", beachDTO.getClean());
		model.addAttribute("game", beachDTO.getGame());

		return "BeachSucess.jsp";
	}

}
