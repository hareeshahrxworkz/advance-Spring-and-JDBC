package com.xworkz.forest.festivalboot;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.forest.entity.FestivalEntity;

public class FindRegionAndMainGoldByNameRunner {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("FindRegionAndMainGoldByName");
		query.setParameter("by", "Yugadi");

		Object[] obj = (Object[]) query.getSingleResult();

		for (Object object : obj) {
			System.out.println(object);

		}
	}

}
