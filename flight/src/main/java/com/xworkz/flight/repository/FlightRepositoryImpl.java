package com.xworkz.flight.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.flight.entity.FlightEntity;

@Repository
public class FlightRepositoryImpl implements FlightRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public FlightRepositoryImpl() {
		System.out.println("Running FlightRepositoryImpl");
	}

	@Override
	public boolean save(FlightEntity entity) {
		System.out.println("Running save");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entity);
		entityTransaction.commit();
		entityManager.close();
		return true;
	}

	@Override
	public FlightEntity findByID(int id) {
		System.out.println("Running Finding repository");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		FlightEntity find = entityManager.find(FlightEntity.class, id);
		entityManager.close();
		return find;
	}

	@Override
	public FlightEntity delete(int id) {

		System.out.println("Running Delete Repository");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		FlightEntity entity = entityManager.find(FlightEntity.class, id);
		if (entity != null) {
			transaction.begin();
			entityManager.remove(entity);
			transaction.commit();
			entityManager.close();
			return entity;
		}
		else {
			return null;
		}

	}

}
