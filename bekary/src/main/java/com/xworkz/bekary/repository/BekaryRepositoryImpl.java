package com.xworkz.bekary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.bekary.dto.BekaryDTO;
@Repository
public class BekaryRepositoryImpl implements BekaryRepository {

	public BekaryRepositoryImpl() {
		System.out.println("Runnning BekaryRepositoryimp");
	}

	@Override
	public boolean save(BekaryDTO bekaryDTO) {
		System.out.println("Running Save");
		return false;
	}

}
