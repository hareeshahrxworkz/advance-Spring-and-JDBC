package com.xworkz.practise.controllor;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.practise.dto.PractiseDTO;
import com.xworkz.practise.repository.PractiseRepo;
import com.xworkz.practise.service.PractiseServic;

@Controller
@RequestMapping("/")
public class PractiseController {

	@Autowired
	PractiseServic practiseServic;
	@Autowired
	PractiseRepo practiseRepo;

	public PractiseController() {
		System.out.println("Running PractiseController");
	}

	@GetMapping("abc")

	public String getData(Model model, PractiseDTO dto) {
		System.out.println("Running control");
		Set<ConstraintViolation<PractiseDTO>> validate = practiseServic.validateAndSave(dto);
		if (validate.isEmpty()) {
			System.out.println("validation complete next save data");
			boolean save = practiseRepo.saveDto(dto);
			System.out.println(save);
		} else {
			System.out.println("voilation is there print display");
			model.addAttribute("error", validate);
		}

		model.addAttribute("names", dto.getName());
		System.out.println(dto.getName());
		return "index";

	}

	@GetMapping("findall")

	public String findAll(Model model, @RequestParam int id)

	{
		System.out.println("Running find method");
		PractiseDTO dto = practiseServic.onfind(id);
		model.addAttribute("dtos", dto);

		return "index";
	}

}
