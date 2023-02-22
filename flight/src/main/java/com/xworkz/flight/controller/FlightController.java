package com.xworkz.flight.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.flight.dto.FlightDTO;
import com.xworkz.flight.entity.FlightEntity;
import com.xworkz.flight.repository.FlightRepository;
import com.xworkz.flight.service.FlightService;

@Controller
@RequestMapping("/")
public class FlightController {
	@Autowired
	private FlightService flightService;
	@Autowired
	private FlightRepository flightRepository;

	private List<String> type = Stream.of("Fighters", "Bombers", "Reconnaissance", "aircraft", "Transport", "Ruslan")
			.collect(Collectors.toList());
	private List<String> country = Stream
			.of("India", "USA", "China", "America", "Russia", "Iran", "Japan", "Singpur", "Srilanka", "bhuthan")
			.collect(Collectors.toList());

	public FlightController() {

		System.out.println("Running " + getClass().getSimpleName());

	}

	@GetMapping("/flight")
	public String onflight(Model model) {
		System.out.println("Running onflight");
		model.addAttribute("type", type);
		model.addAttribute("country", country);
		return "Flight";
	}

	@PostMapping("/flight")
	public String onFlight(Model model, FlightDTO dto) {
		System.out.println("Running onflight");
		model.addAttribute("type", type);
		model.addAttribute("country", country);
		Set<ConstraintViolation<FlightDTO>> violations = flightService.validateandSave(dto);
		if (violations.isEmpty()) {
			System.out.println("is no voilations you can save now" + dto);
			FlightEntity entity = new FlightEntity();
			entity.setName(dto.getName());
			entity.setType(dto.getType());
			entity.setCost(dto.getCost());
			entity.setCountry(dto.getCountry());
			entity.setFname(dto.getFname());
			boolean save = flightRepository.save(entity);
			System.out.println("Data will be saved" + save);
			model.addAttribute("sucess", "Data Save Sucessfully");

		} else {
			System.out.println("Violation is occured please contact Flight page");
			model.addAttribute("error", violations);
			model.addAttribute("failure", "Data Does Not Save failures ");

		}
		return "Flight";

	}

	@GetMapping("/find")
	public String onFind(@RequestParam int id, Model model) {
		System.out.println("Find Is Running");
		FlightDTO dto = flightService.onFindBy(id);
		if (dto != null) {
			model.addAttribute("dto",dto);
		} else {
			model.addAttribute("nu", "Does not find Records in the database");
		}
		return "index";
	}

}
