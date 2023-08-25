package com.xworkz.hareeshaxworkz.entity;

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
@Setter
@Getter
@Entity
@Table(name = "game")
@NamedQuery(name = "findByName", query = "select entity from HareeshaEntity entity where entity.name=:by")
@NamedQuery(name = "findById", query = "select entity from HareeshaEntity entity where entity.id=:byid")
@NamedQuery(name = "findByonline", query = "select entity from HareeshaEntity entity where entity.online=:byonline")
@NamedQuery(name = "findByNoOfLevels", query = "select entity from HareeshaEntity entity where entity.NoOfLevels=:byNoOfLevels")
@NamedQuery(name = "findBytype", query = "select entity from HareeshaEntity entity where entity.type=:bytype")
@NamedQuery(name = "findByWepon", query = "select entity from HareeshaEntity entity where entity.Wepon=:byWepon")
//@NamedQuery(name = "findByletter", query = "select entity from HareeshaEntity entity where entity.name like %bylet%")

@NamedQuery(name = "findAll", query = "select entity from HareeshaEntity entity ")

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
