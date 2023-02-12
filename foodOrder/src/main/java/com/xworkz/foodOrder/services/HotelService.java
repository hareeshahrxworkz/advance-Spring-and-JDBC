package com.xworkz.foodOrder.services;

import com.xworkz.foodOrder.dto.OrderDTO;

public interface HotelService {

	boolean validateAndSave(OrderDTO dto);
	

}
