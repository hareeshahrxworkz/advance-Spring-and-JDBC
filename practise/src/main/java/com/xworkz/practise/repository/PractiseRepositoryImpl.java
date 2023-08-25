package com.xworkz.practise.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.practise.dto.PractiseDTO;

@Repository
public class PractiseRepositoryImpl implements PractiseRepo {
	public PractiseRepositoryImpl() {
		System.out.println("Running Repository");
	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean saveDto(PractiseDTO dto) {
		System.out.println("Saving process Running");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
		entityManager.close();
		return true;
	}

	@Override
	public PractiseDTO find(int id) {
		System.out.println("find by name Runninng");
		EntityManager manager = entityManagerFactory.createEntityManager();
		PractiseDTO dto = manager.find(PractiseDTO.class, id);
		System.out.println(dto);
		return dto;
	}

}
