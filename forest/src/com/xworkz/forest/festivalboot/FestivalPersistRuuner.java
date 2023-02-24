package com.xworkz.forest.festivalboot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.forest.entity.FestivalEntity;

public class FestivalPersistRuuner {
	public static void main(String[] args) {

		System.out.println("Running MAin method");
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		FestivalEntity entity = new FestivalEntity("makara Sankranti", "Hindu", 1, "Kabbu", "seeds");
		FestivalEntity entity1 = new FestivalEntity("shivaratri", "Hindu", 1, "Jagarane", "Tomata");
		FestivalEntity entity2 = new FestivalEntity("Yugadi", "Hindu", 2, "Obbatu", "BevuBella");
		FestivalEntity entity3 = new FestivalEntity("pongal", "Hindu", 1, "Pongal", "Pongal");
		FestivalEntity entity4 = new FestivalEntity("Holi ", "Hindu", 2, "Sweet", "sweet");
		FestivalEntity entity5 = new FestivalEntity("Baisakhi ", "Muslim", 1, "Kabbu", "Chikan");
		FestivalEntity entity6 = new FestivalEntity("Budda Jayanti ", "Jainis", 1, "Sweet", "nekles");
		FestivalEntity entity7 = new FestivalEntity("Krishna Janmastami", "Hindu", 1, "Olige", "Kolalu");
		FestivalEntity entity8 = new FestivalEntity("Independence Day", "All", 1, "Bisket", "Flag");
		FestivalEntity entity9 = new FestivalEntity("Onam", "Krist", 1, "Biriyani", "Sewwt");
		FestivalEntity entity10 = new FestivalEntity("Ganesha Chaturti", "Hindu", 1, "Laddu", "Ganesha stachu");
		FestivalEntity entity11 = new FestivalEntity("Navaratri", "Hindu", 1, "Bella", "Ambari");
		FestivalEntity entity12 = new FestivalEntity("Durga pooja ", "Hindu", 1, "Sweet", "Place");
		FestivalEntity entity13 = new FestivalEntity("Dipavali", "Hindu", 1, "Chakli", "Deepa");
		FestivalEntity entity14 = new FestivalEntity("Charitamas", "Kritchen", 1, "beriyani", "jisus");
		manager.persist(entity);
		manager.persist(entity1);
		manager.persist(entity2);
		manager.persist(entity3);
		manager.persist(entity4);
		manager.persist(entity5);
		manager.persist(entity6);
		manager.persist(entity7);
		manager.persist(entity8);
		manager.persist(entity9);
		manager.persist(entity10);
		manager.persist(entity11);
		manager.persist(entity12);
		manager.persist(entity13);
		manager.persist(entity14);
		transaction.commit();
		manager.close();

	}

}
