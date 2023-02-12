package com.xworkz.hotel.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceProperty;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import com.mysql.cj.jdbc.Driver;
import com.xworkz.hotel.dto.OrderDTO;

@Repository
public class HotelRepositoryimpl implements HotelRepository {
	@Autowired
	private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public HotelRepositoryimpl() {
		System.out.println("HotelRepository Implementation Running");
	}

	@Override
	public boolean save(OrderDTO dto) {
		System.out.println("Save Running");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(dto);
		transaction.commit();
		entityManager.close();
		System.out.println(dto);
		return false;
	}

}
