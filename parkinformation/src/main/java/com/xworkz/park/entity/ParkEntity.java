package com.xworkz.park.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "park_table")
public class ParkEntity {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "visitorNme")
	private String visitorNme;
	@Column(name = "parkName")
	private String parkName;
	@Column(name = "place")
	private String place;
	@Column(name = "week")
	private String week;
	@Column(name = "review")
	private String review;

}
