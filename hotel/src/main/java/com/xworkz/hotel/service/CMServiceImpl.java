package com.xworkz.hotel.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.hotel.dto.CMDTO;
import com.xworkz.hotel.repository.CMRepository;

@Service
public class CMServiceImpl implements CMService {
	@Autowired
	private CMRepository cMRepository;

	@Override
	public Set<ConstraintViolation<CMDTO>> ValidateAndSave(CMDTO cmdto) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<CMDTO>> constraintViolations = validator.validate(cmdto);
		if (!constraintViolations.isEmpty()) {
			System.out.println("error is created ");
			return constraintViolations;

		} else {
			System.out.println(" set is emptyvalidation is done ");
			System.out.println(cmdto);
			return constraintViolations;

		}
	}

}
