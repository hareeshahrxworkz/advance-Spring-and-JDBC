package com.xworkz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.hotel.dto.OrderDTO;
import com.xworkz.hotel.service.HotelService;

@Controller
@RequestMapping("/order")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	public HotelController() {
		System.out.println("Running Hotel Controller");
	}

	@PostMapping()
	public String onOrder(OrderDTO dto) {
		System.out.println("Running On order DTO");
		boolean save = this.hotelService.validateAndSave(dto);
		System.out.println("Saved " + save);
		return "Display";

	}

}
