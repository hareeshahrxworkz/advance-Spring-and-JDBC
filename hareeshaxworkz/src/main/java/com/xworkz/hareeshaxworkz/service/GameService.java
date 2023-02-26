package com.xworkz.hareeshaxworkz.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.hareeshaxworkz.dto.HareeshaDTO;

public interface GameService {

	Set<ConstraintViolation<HareeshaDTO>> validateAndSave(HareeshaDTO dto);

	HareeshaDTO find(int id);

}
