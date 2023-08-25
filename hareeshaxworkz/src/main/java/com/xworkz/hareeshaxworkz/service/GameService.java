package com.xworkz.hareeshaxworkz.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.hareeshaxworkz.dto.HareeshaDTO;
import com.xworkz.hareeshaxworkz.entity.HareeshaEntity;

public interface GameService {

	Set<ConstraintViolation<HareeshaDTO>> validateAndSave(HareeshaDTO dto);

	List<HareeshaDTO> find(String all);

	default List<HareeshaDTO> Byname(String name) {

		return Collections.emptyList();

	}

	default HareeshaDTO onFind(int id) {
		return null;
	}

	default HareeshaDTO onDelete(int id) {
		return null;
	}

}
