package com.xworkz.flight.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.flight.dto.FlightDTO;
import com.xworkz.flight.entity.FlightEntity;
import com.xworkz.flight.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;

	public FlightServiceImpl() {
		System.out.println("Running FlightServiceImpl");
	}

	@Override
	public Set<ConstraintViolation<FlightDTO>> validateandSave(FlightDTO dto) {
		System.out.println("Running validateandSave");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<FlightDTO>> violations = factory.getValidator().validate(dto);
		if (!violations.isEmpty()) {
			System.out.println("Validation violations is there ");
			return violations;
		} else {
			System.out.println("No violation You can save it");
			return Collections.emptySet();
		}
	}

	@Override
	public FlightDTO onFindBy(int id) {
		System.out.println("Running Find Services");
		if (id > 0) {

			FlightEntity entity = this.flightRepository.findByID(id);
			if (entity != null) {
				System.out.println("entity is there print the dto");
				FlightDTO dto = new FlightDTO();
				dto.setCost(entity.getCost());
				dto.setCountry(entity.getCountry());
				dto.setFname(entity.getFname());
				dto.setName(entity.getName());
				dto.setType(entity.getType());
				return dto;

			}

		}
		return null;
	}

	@Override
	public FlightDTO onDelete(int id) {
		System.out.println("Running Service DElete");
		FlightEntity entity = flightRepository.delete(id);
		if (entity!=null) {
			FlightDTO dto = new FlightDTO();
			dto.setCost(entity.getCost());
			dto.setCountry(entity.getCountry());
			dto.setFname(entity.getFname());
			dto.setName(entity.getName());
			dto.setType(entity.getType());
			return dto;
		}
		return null;
	}

}
