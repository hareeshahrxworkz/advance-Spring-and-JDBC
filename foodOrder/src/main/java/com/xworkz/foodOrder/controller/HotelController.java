package com.xworkz.foodOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.foodOrder.services.HotelService;
import com.xworkz.foodOrder.dto.OrderDTO;

@Controller
@RequestMapping("/")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	public HotelController() {
		System.out.println("Running Hotel Controller");
	}

	@PostMapping("/order")
	public String onOrder(OrderDTO dto) {
		System.out.println("Running On order DTO");
		boolean save = this.hotelService.validateAndSave(dto);
		System.out.println("Saved " + save);
		return "Display";

	}

}
