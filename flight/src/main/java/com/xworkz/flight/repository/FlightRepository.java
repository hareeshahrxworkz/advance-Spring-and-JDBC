package com.xworkz.flight.repository;

import com.xworkz.flight.entity.FlightEntity;

public interface FlightRepository {

	boolean save(FlightEntity entity);

	FlightEntity findByID(int id);

}
