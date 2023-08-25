package com.xworkz.practise.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.practise.dto.PractiseDTO;

public interface PractiseServic {

	Set<ConstraintViolation<PractiseDTO>> validateAndSave(PractiseDTO dto);

	default PractiseDTO onfind(int id) {
		return null;
	}

}
