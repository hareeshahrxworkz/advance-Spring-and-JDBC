package com.xworkz.email.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.email.dto.EmailDTO;

public interface EmailService {

	public Set<ConstraintViolation<EmailDTO>> ValidateAndSave(EmailDTO dto);

	public boolean sendEmail(EmailDTO dto, String email);

	default List<EmailDTO> byEmail(String mail) {

		return Collections.emptyList();

	}


}
