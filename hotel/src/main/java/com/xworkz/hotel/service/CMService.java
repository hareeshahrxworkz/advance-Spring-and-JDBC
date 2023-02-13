package com.xworkz.hotel.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.hotel.dto.CMDTO;

public interface CMService {
	Set<ConstraintViolation<CMDTO>> ValidateAndSave(CMDTO cmdto);

}
