package com.xworkz.email.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.email.entity.EmailEntity;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EmailRepositoryImpl() {
		System.out.println("Running" + getClass().getSimpleName());
	}

	@Override
	public boolean save(EmailEntity entity) {
		System.out.println("Running Saving Process");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();

		return true;

	}

	@Override
	public List<EmailEntity> byEmail(String mail) {
		System.out.println("Running Find Method");
		int i = 0;
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			if (mail != null) {
				System.out.println("=======================");

				Query query = manager.createNamedQuery("findByEmail");
				query.setParameter("bymail", mail);
				List<EmailEntity> lists = query.getResultList();
				if (!lists.isEmpty()) {

					System.out.println(lists.size());
					return lists;
				} else if (mail != null)
					try {
						i = Integer.parseInt(mail);

					} catch (Exception e) {
					}
			}
		} finally {
			manager.close();
		}
		return EmailRepository.super.byEmail(mail);
	}

	@Override
	public boolean onUpdate(EmailEntity entity) {
		System.out.println("Email Updateing Running");
		EntityManager manager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		transaction.commit();
		System.out.println(entity);
		manager.close();

		return true;

	}

}
