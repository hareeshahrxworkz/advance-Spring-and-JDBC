package com.xworkz.forest.festivalboot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindTotalDaysByName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("FindTotalDaysByName");
		query.setParameter("by", "Yugadi");

		Object obj = query.getSingleResult();

		int entity = (int) obj;
		System.out.println(entity);
	}
}
