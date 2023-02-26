package com.xworkz.hareeshaxworkz.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.hareeshaxworkz.dto.HareeshaDTO;
import com.xworkz.hareeshaxworkz.entity.HareeshaEntity;
import com.xworkz.hareeshaxworkz.repository.GameRepository;
import com.xworkz.hareeshaxworkz.service.GameService;

@Controller
@RequestMapping("/")
public class HareeshaController {
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private GameService gameService;

	private List<String> online = Stream.of("Online", "Offline").collect(Collectors.toList());
	private List<Integer> levels = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
			.collect(Collectors.toList());
	private List<Integer> playars = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).collect(Collectors.toList());

	public HareeshaController() {
		System.out.println("Running " + getClass().getSimpleName());
	}

	@GetMapping("/game")
	public String onGame(Model model) {
		System.out.println("Running on get Game");
		model.addAttribute("online", online);
		model.addAttribute("levels", levels);
		model.addAttribute("playars", playars);

		return "GameRegister";
	}

	@PostMapping("/game")
	public String onGame(Model model, HareeshaDTO dto) {
		System.out.println("Running on post Game");
		model.addAttribute("online", online);
		model.addAttribute("levels", levels);
		model.addAttribute("playars", playars);
		model.addAttribute("dto", dto);
		Set<ConstraintViolation<HareeshaDTO>> violations = gameService.validateAndSave(dto);
		if (violations.isEmpty()) {
			System.out.println("vilioations is not there ");
			HareeshaEntity entity = new HareeshaEntity();
			entity.setName(dto.getName());
			entity.setNoOfLevels(dto.getNoOfLevels());
			entity.setOnline(dto.getOnline());
			entity.setPlayars(dto.getPlayars());
			entity.setType(dto.getType());
			entity.setWepon(dto.getWepon());
			boolean save = gameRepository.save(entity);
			System.out.println(save);

			return "GameRegister";

		}

		else {
			model.addAttribute("error", violations);
			return "GameRegister";
		}
	}

	@GetMapping("find")

	public String find(Model model, @RequestParam int id) {
		System.out.println("Running fing method");
	
			HareeshaDTO dto = gameService.find(id);
			if (dto != null) {
				model.addAttribute("dto", dto);
				return "index";
			} else {

				model.addAttribute("err", "Dto is null cannot find game Detiles");

				model.addAttribute("dto", dto);
				return "index";
			}
		} 

	

}
