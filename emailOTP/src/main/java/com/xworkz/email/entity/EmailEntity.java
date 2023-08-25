package com.xworkz.email.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "email")
@NamedQuery(name = "findByEmail", query = "select entity from EmailEntity entity where entity.email=:bymail")

public class EmailEntity {
	@Id
	private int id;
	@Column(name = "email")
	private String email;
	@Column(name = "otp")
	private String otp;
	@Column(name = "fname")
	private String fName;
	@Column(name = "mobileNo")
	private String mobileNo;
	@Column(name = "lname")
	private String lname;

}
