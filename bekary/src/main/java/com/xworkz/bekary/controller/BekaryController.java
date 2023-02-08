package com.xworkz.bekary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.bekary.dto.BekaryDTO;
import com.xworkz.bekary.service.BekaryService;

@Controller
@RequestMapping("/")
public class BekaryController {
	@Autowired
	private BekaryService bekaryService;

	public BekaryController() {
		System.out.println("Running Bekary Controller");
	}

	@GetMapping("/save")
	public String onBekary(BekaryDTO bekaryDTO, Model model) {
		model.addAttribute("bekary", bekaryDTO);
		boolean save = bekaryService.validateAndSave(bekaryDTO);
		System.out.println(save);
		return "display";
	}

}
