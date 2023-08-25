package com.xworkz.email.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.email.dto.EmailDTO;
import com.xworkz.email.entity.EmailEntity;

public interface EmailRepository {

	public boolean save(EmailEntity entity);

	default List<EmailEntity> byEmail(String mail) {

		return Collections.emptyList();

	}

	default boolean onUpdate(EmailEntity entity) {
		return true;
	}

}
