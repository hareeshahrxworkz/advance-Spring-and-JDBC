package com.xworkz.forest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "forest")
@ToString
@NoArgsConstructor
@Getter
@Setter
@NamedQuery(name = "findByName", query = "select for from ForestEntity for where for.name='Bandipura'")
@NamedQuery(name = "FindByState", query = ("select for from ForestEntity for where  for.state='Karnataka' "))
@NamedQuery(name = "FindByNameAndState", query = ("select for.area,for.state from ForestEntity for where name='Uttarakhand'"))
@NamedQuery(name = "FindAreabyname", query = ("select  for.area from ForestEntity for where for.name='Birds'"))
@NamedQuery(name = "findidAndname", query = ("select for.id from ForestEntity for where for.name='Sundarbans' and for.state='Karnataka'"))
@NamedQuery(name = "findNameByID", query = ("select for.name from ForestEntity for where id=1"))
@NamedQuery(name = "findCount", query = ("select count(for.id) from ForestEntity for "))
@NamedQuery(name = "maxArea", query = ("select Max(for.id) from ForestEntity for "))
public class ForestEntity {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "state")
	private String state;
	@Column(name = "area")
	private String area;
	@Column(name = "type")
	private String type;

}
