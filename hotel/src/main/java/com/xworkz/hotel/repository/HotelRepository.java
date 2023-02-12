package com.xworkz.hotel.repository;

import com.xworkz.hotel.dto.OrderDTO;

public interface HotelRepository {
	boolean save(OrderDTO dto);

}
