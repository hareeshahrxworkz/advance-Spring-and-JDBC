package com.xworkz.practise.repository;

import com.xworkz.practise.dto.PractiseDTO;

public interface PractiseRepo {
	
	 boolean saveDto(PractiseDTO dto);
	default PractiseDTO find(int id)
	{
		return null;
	}

}
