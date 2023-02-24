package com.xworkz.forest.festivalboot;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.forest.entity.FestivalEntity;

public class FindByNameAndRegionAndMainGold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("FindByNameAndRegionAndMainGold");
		query.setParameter("rby", "Hindu");
		query.setParameter("mby", "Tomata");

		Object obj = query.getSingleResult();

		String entity = (String) obj;
		System.out.println(entity);

	}

}
