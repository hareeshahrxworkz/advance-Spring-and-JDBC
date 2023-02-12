package com.xworkz.hotel.service;

import com.xworkz.hotel.dto.OrderDTO;

public interface HotelService {

	boolean validateAndSave(OrderDTO dto);

}
