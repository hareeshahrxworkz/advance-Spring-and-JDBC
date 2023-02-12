package com.xworkz.foodOrder.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import com.xworkz.foodOrder.dto.OrderDTO;

@Repository
public class HotelRepositoryimpl implements HotelRepository {
	@Autowired
	private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public HotelRepositoryimpl() {
		System.out.println("HotelRepository Implementation unning");
	}

	@Override
	public boolean save(OrderDTO dto) {
		System.out.println("Save Running");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
		entityManager.close();
		System.out.println(dto);
		
		Driver
		
		return false;
	}

}
