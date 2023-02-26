package com.xworkz.hareeshaxworkz.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.hareeshaxworkz.entity.HareeshaEntity;

@Repository
public class GameRepositoryimpl implements GameRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public GameRepositoryimpl() {
		System.out.println("Running GameRepositoryimpl");
	}

	@Override
	public boolean save(HareeshaEntity entity) {
		EntityManager manager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		System.out.println(entity);
		manager.close();

		return true;
	}

	@Override
	public HareeshaEntity find(int id) {

		EntityManager manager = entityManagerFactory.createEntityManager();
		HareeshaEntity entity = manager.find(HareeshaEntity.class, id);
		manager.close();
		return entity;
	}

}
