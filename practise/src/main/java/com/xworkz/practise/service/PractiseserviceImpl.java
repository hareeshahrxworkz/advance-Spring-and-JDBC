package com.xworkz.practise.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.practise.dto.PractiseDTO;
import com.xworkz.practise.repository.PractiseRepo;

@Service
public class PractiseserviceImpl implements PractiseServic {

	@Autowired
	private PractiseRepo practiseRepo;

	public PractiseserviceImpl() {
		System.out.println("Running service ");
	}

	@Override
	public Set<ConstraintViolation<PractiseDTO>> validateAndSave(PractiseDTO dto) {
		System.out.println("Dto Validating Running");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<PractiseDTO>> voilation = factory.getValidator().validate(dto);
		if (voilation.isEmpty()) {
			System.out.println("vilation is not there");
			return Collections.emptySet();
		} else {
			System.out.println("vilation is there ");
			return voilation;

		}

	}

	@Override
	public PractiseDTO onfind(int id) {
		System.out.println("on find method running sucessfully in service");
		PractiseDTO dto=practiseRepo.find(id);
		
		System.out.println("Service dto"+dto);

		if(dto!=null)
		{
			return dto;
		}

		
		return PractiseServic.super.onfind(id);
	}

}
