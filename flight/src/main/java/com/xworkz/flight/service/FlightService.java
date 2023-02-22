package com.xworkz.flight.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.flight.dto.FlightDTO;

public interface FlightService {
	Set<ConstraintViolation<FlightDTO>> validateandSave(FlightDTO dto);

	FlightDTO onFindBy(int id);
	
	
	

}
