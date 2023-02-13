package com.xworkz.hotel.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
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
			System.out.println("Constraints does  exists!!! ");
			return constraintViolations;

		} else {
			System.out.println("Constraints does  existsyou will do save operation ");
			System.out.println(cmdto);
			return Collections.emptySet();

		}
	}

}
