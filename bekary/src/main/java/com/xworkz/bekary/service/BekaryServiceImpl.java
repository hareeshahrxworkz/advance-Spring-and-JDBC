package com.xworkz.bekary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.bekary.dto.BekaryDTO;
import com.xworkz.bekary.repository.BekaryRepository;

@Service
public class BekaryServiceImpl implements BekaryService {
	@Autowired
	private BekaryRepository bekaryRepository;

	public BekaryServiceImpl() {
		System.out.println("Running BekaryServiceImpl");
	}

	@Override
	public boolean validateAndSave(BekaryDTO bekaryDTO) {
		System.out.println("Running validateAndSave");
		boolean save = bekaryRepository.save(bekaryDTO);
		System.out.println("Save " + save);
		return false;
	}

}
