package com.xworkz.foodOrder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.foodOrder.dto.OrderDTO;
import com.xworkz.foodOrder.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	public HotelServiceImpl() {
		System.out.println("Running Hotel Service ImplementationS");
	}

	@Override
	public boolean validateAndSave(OrderDTO dto) {
		System.out.println("Running Validate And Save Method");
		boolean save = this.hotelRepository.save(dto);
		System.out.println("Saved " + save);
		return false;
	}
}
