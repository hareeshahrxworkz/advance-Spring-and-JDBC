package com.xworkz.forest.festivalboot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMainGoldAndTotaldaysAndByNameRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("FindMainGoldAndTotaldaysAndByName");
		query.setParameter("by", "Krishna Janmastami");

		Object[] obj = (Object[]) query.getSingleResult();

		for (Object object : obj) {
			System.out.println(object);
		}
	}

}
