package com.xworkz.park.service;

import java.text.Collator;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.xworkz.park.dto.ParkDTO;

@Service
public class ParkServiceImpl implements ParkService {

	public ParkServiceImpl() {
		System.out.println("Running ParkServiceImpl");
	}

	@Override
	public Set<ConstraintViolation<ParkDTO>> validateAndSave(ParkDTO dto) {
		System.out.println("Running  ParkServiceImpl validating start");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<ParkDTO>> violations = factory.getValidator().validate(dto);
		if (!violations.isEmpty()) {
			System.out.println("violenctions error");
			return violations;
		} else {
			System.out.println("Vilations is good no error save the data");
			return Collections.emptySet();

		}
	}

}
