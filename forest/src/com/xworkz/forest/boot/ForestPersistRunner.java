package com.xworkz.forest.boot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.forest.entity.ForestEntity;

public class ForestPersistRunner {
	public static void main(String[] args) {
		ForestEntity entity = new ForestEntity();
		entity.setArea("Nilgiri Reserve");
		entity.setName(" Biosphere");
		entity.setState("Tamil nadu");
		entity.setType("Cholanaickens");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
		entityManager.close();
		System.out.println(entity);

	}

}
