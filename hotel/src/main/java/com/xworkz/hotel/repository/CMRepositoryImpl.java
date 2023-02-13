package com.xworkz.hotel.repository;

import org.springframework.stereotype.Repository;

import com.xworkz.hotel.dto.CMDTO;

@Repository
public class CMRepositoryImpl implements CMRepository {
	public CMRepositoryImpl() {
		System.out.println("Running CMRepositoryImpl");
	}

	@Override
	public boolean save(CMDTO cmdto) {
		System.out.println("Running Save");
		return true;
	}

}
