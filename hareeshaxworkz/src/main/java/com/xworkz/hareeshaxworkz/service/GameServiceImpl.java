package com.xworkz.hareeshaxworkz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.hareeshaxworkz.dto.HareeshaDTO;
import com.xworkz.hareeshaxworkz.entity.HareeshaEntity;
import com.xworkz.hareeshaxworkz.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired

	private GameRepository gameRepository;

	public GameServiceImpl() {

		System.out.println("Running GameServiceImpl");
	}

	@Override
	public Set<ConstraintViolation<HareeshaDTO>> validateAndSave(HareeshaDTO dto) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<HareeshaDTO>> violations = factory.getValidator().validate(dto);
		if (violations.isEmpty()) {
			System.out.println("viloation is not there please save it");
			return Collections.emptySet();
		} else {
			System.out.println("viloation is there dont save operation");
			return violations;
		}

	}

	@Override
	public List<HareeshaDTO> find(String all) {
		System.out.println("Running find method");
		List<HareeshaEntity> lists = gameRepository.find(all);

		if (lists != null && !lists.isEmpty()) {
			List<HareeshaDTO> dtos = new ArrayList<HareeshaDTO>();
			for (HareeshaEntity entity : lists) {

				HareeshaDTO dto = new HareeshaDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setNoOfLevels(entity.getNoOfLevels());
				dto.setOnline(entity.getOnline());
				dto.setPlayars(entity.getPlayars());
				dto.setType(entity.getType());
				dto.setWepon(entity.getWepon());
				dtos.add(dto);
			}
			return dtos;

		} else {
			System.out.println("Dto is nulll");
			return GameService.super.Byname(all);

		}
	}

	@Override
	public List<HareeshaDTO> Byname(String name) {

		List<HareeshaEntity> lists = gameRepository.Byname(name);

		if (lists != null && !lists.isEmpty()) {
			List<HareeshaDTO> dtos = new ArrayList<HareeshaDTO>();
			for (HareeshaEntity entity : lists) {

				HareeshaDTO dto = new HareeshaDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setNoOfLevels(entity.getNoOfLevels());
				dto.setOnline(entity.getOnline());
				dto.setPlayars(entity.getPlayars());
				dto.setType(entity.getType());
				dto.setWepon(entity.getWepon());
				dtos.add(dto);
			}
			return dtos;

		} else {
			System.out.println("Dto is nulll");
			return GameService.super.Byname(name);

		}
	}

	@Override
	public HareeshaDTO onDelete(int id) {

		HareeshaEntity entity = gameRepository.onDelete(id);
		if (entity != null) {

			HareeshaDTO dto = new HareeshaDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setNoOfLevels(entity.getNoOfLevels());
			dto.setOnline(entity.getOnline());
			dto.setPlayars(entity.getPlayars());
			dto.setType(entity.getType());
			dto.setWepon(entity.getWepon());
			return dto;

		} else {
			return GameService.super.onDelete(id);
		}
	}

}
