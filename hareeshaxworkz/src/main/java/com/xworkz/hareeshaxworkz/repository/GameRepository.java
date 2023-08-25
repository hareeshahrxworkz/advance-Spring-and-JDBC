package com.xworkz.hareeshaxworkz.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.xworkz.hareeshaxworkz.dto.HareeshaDTO;
import com.xworkz.hareeshaxworkz.entity.HareeshaEntity;

public interface GameRepository {

	boolean save(HareeshaEntity entity);

	List<HareeshaEntity> find(String all);

	default List<HareeshaEntity> Byname(String name) {

		return Collections.emptyList();

	}

	default HareeshaEntity onDelete(int id) {
		return null;
	}

	default HareeshaEntity onFind(int id) {
		return null;
	}

	default boolean onUpdate(HareeshaEntity entity) {
		return true;
	}

}
