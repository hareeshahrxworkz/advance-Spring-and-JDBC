package com.xworkz.park.controller;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.park.dto.ParkDTO;
import com.xworkz.park.entity.ParkEntity;
import com.xworkz.park.repository.ParkRepository;
import com.xworkz.park.service.ParkService;

@Controller
@RequestMapping("/park")
public class ParkController {
	@Autowired
	private ParkRepository parkRepository;
	@Autowired
	private ParkService parkService;
	private List<String> places = Stream.of("Rajajinagara", "vijayanagara", "Basaveshwaranagara", "kabban park",
			"lolbog", "kuvempu nagar", "BTm", "HsrLayout", "Indiranagara", "ShantiNagara", "Madivala")
			.collect(Collectors.toList());
	private List<String> week = Stream.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
			.collect(Collectors.toList());

	public ParkController() {
		System.out.println("Park contoroller running");
	}

	@GetMapping
	public String onPark(Model model) {
		System.out.println("Running on park");
		model.addAttribute("place", places);
		model.addAttribute("week", week);

		return "ParkEnter";
	}

	@PostMapping
	public String onPark(ParkDTO dto, Model model) {
		System.out.println("Running OnPark Overloaded Method");
		Set<ConstraintViolation<ParkDTO>> violations = parkService.validateAndSave(dto);
		if (violations.isEmpty()) {
			System.out.println("Validation is sucess no error save it");
			ParkEntity entity = new ParkEntity();
			entity.setParkName(dto.getParkName());
			entity.setVisitorNme(dto.getVisitorNme());
			entity.setPlace(dto.getPlace());
			entity.setWeek(dto.getWeek());
			entity.setReview(dto.getReview());
			boolean save = parkRepository.save(entity);
			System.out.println("Saving done " + save);
			return "ParkSucess";
		} else {
			System.out.println("Validation is error print the jsp page");
			model.addAttribute("place", places);
			model.addAttribute("week", week);
			model.addAttribute("message", violations);
			return "ParkEnter";
		}

	}

}
