package com.xworkz.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "flight")
public class FlightEntity {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "C_name")
	private String name;
	@Column(name = "f_name")
	private String fname;
	@Column(name = "cost")
	private String cost;
	@Column(name = "type")
	private String type;
	@Column(name = "country")
	private String country;

}
