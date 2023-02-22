package com.xworkz.park.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.park.dto.ParkDTO;

public interface ParkService {

	Set<ConstraintViolation<ParkDTO>> validateAndSave(ParkDTO dto);
}
