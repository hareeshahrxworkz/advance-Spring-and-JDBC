package com.xworkz.foodOrder.repository;

import com.xworkz.foodOrder.dto.OrderDTO;

public interface HotelRepository {
	boolean save(OrderDTO dto);

}
