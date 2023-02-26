package com.xworkz.hareeshaxworkz.repository;

import com.xworkz.hareeshaxworkz.entity.HareeshaEntity;

public interface GameRepository {

	boolean save(HareeshaEntity entity);

	HareeshaEntity find(int id);

}
