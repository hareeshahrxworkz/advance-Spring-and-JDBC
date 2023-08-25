package com.xworkz.hareeshaxworkz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.hareeshaxworkz.dto.HareeshaDTO;
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
	public HareeshaEntity onFind(int id) {

		EntityManager manager = entityManagerFactory.createEntityManager();
		HareeshaEntity entity = manager.find(HareeshaEntity.class, id);
		manager.close();
		return entity;
	}

	@Override
	public List<HareeshaEntity> find(String all) {

		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			if (all != null) {

				Query query = manager.createNamedQuery("findAll");

				List<HareeshaEntity> list = query.getResultList();
				if (!list.isEmpty()) {
					return list;
				}
			}
		}

		finally {

			manager.close();
		}
		return null;
	}

	@Override
	public List<HareeshaEntity> Byname(String name) {
		Integer i = 0;
		System.out.println("Running Byname");
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			if (name != null) {
				System.out.println("=======================");

				Query query = manager.createNamedQuery("findByName");
				query.setParameter("by", name);
				List<HareeshaEntity> lists = query.getResultList();
				if (!lists.isEmpty()) {

					System.out.println(lists.size());
					return lists;
				} else if (name != null)
					try {
						i = Integer.parseInt(name);

					} catch (Exception e) {
					}

				Query query1 = manager.createNamedQuery("findById");

				query1.setParameter("byid", i);
				List<HareeshaEntity> list = query1.getResultList();

				if (!list.isEmpty()) {
					System.out.println(list.size());
					return list;
				} else if (name != null) {

					Query query2 = manager.createNamedQuery("findByonline");

					query2.setParameter("byonline", name);

					List<HareeshaEntity> list2 = query2.getResultList();
					if (!list2.isEmpty()) {
						return list2;
					} else if (name != null) {

						Query query3 = manager.createNamedQuery("findByNoOfLevels");

						query3.setParameter("byNoOfLevels", i);

						List<HareeshaEntity> list3 = query3.getResultList();
						if (!list3.isEmpty()) {
							return list3;
						} else if (name != null) {

							Query query4 = manager.createNamedQuery("findByWepon");

							query4.setParameter("byWepon", name);

							List<HareeshaEntity> list4 = query4.getResultList();
							if (!list4.isEmpty()) {
								return list4;
							} else if (name != null) {

								Query query5 = manager.createNamedQuery("findBytype");

								query5.setParameter("bytype", name);

								List<HareeshaEntity> list5 = query5.getResultList();
								if (!list5.isEmpty()) {
									return list5;
								} else if (name != null) {

									Query query6 = manager.createNamedQuery("findByletter");

									query6.setParameter("bylet", name);

									List<HareeshaEntity> list6 = query6.getResultList();
									if (!list5.isEmpty()) {
										return list6;
									}

									else {
										return GameRepository.super.Byname(name);

									}
								}

							}
						}

					}

				}
			}

		} finally {
			manager.close();
		}
		return GameRepository.super.Byname(name);

	}

	@Override
	public HareeshaEntity onDelete(int id) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		HareeshaEntity entity = manager.find(HareeshaEntity.class, id);
		if (entity != null) {
			transaction.begin();
			manager.remove(entity);
			transaction.commit();
			manager.close();
			return entity;
		} else {
			return GameRepository.super.onDelete(id);

		}
	}

	@Override
	public boolean onUpdate(HareeshaEntity entity) {
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
