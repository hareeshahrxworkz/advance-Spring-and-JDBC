package com.xworkz.hareeshaxworkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "game")
public class HareeshaEntity {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "online")
	private String online;
	@Column(name = "playars")
	private Integer playars;
	@Column(name = "Wepon")
	private String Wepon;
	@Column(name = "NoOfLevels")
	private Integer NoOfLevels;

}
