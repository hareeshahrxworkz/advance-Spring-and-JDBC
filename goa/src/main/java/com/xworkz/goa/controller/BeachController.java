package com.xworkz.goa.controller;

import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.goa.chat.Beachchat;

@Component
@RequestMapping("/beach")
public class BeachController {
	public BeachController() {
		System.out.println("Running : " + getClass().getSimpleName());
	}

	@PostMapping
	public String beachController(Beachchat beachchat, Model model) {
		System.out.println("Running :" + beachchat);
		model.addAttribute("name", beachchat.getName());
		model.addAttribute("location", beachchat.getLocation());
		model.addAttribute("clean", beachchat.getClean());
		model.addAttribute("game", beachchat.getGame());

		return "BeachSucess.jsp";
	}

}
