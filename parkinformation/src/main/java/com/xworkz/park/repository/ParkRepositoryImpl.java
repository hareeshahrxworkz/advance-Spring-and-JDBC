package com.xworkz.park.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.park.entity.ParkEntity;

@Repository
public class ParkRepositoryImpl implements ParkRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ParkRepositoryImpl() {
		System.out.println("Running ParkRepositoryImpl");
	}

	@Override
	public boolean save(ParkEntity entity) {
		System.out.println("Running save");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
		entityManager.close();
		return true;
	}

}
