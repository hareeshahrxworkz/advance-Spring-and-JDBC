package com.xworkz.forest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "festival")
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQuery(name = "FindByIdAndNameRuuner", query = "Select entity.id from FestivalEntity entity where entity.name=:by ")
@NamedQuery(name = "FindByNameAndRegionAndMainGold", query = "select entity.name from FestivalEntity entity where  entity.region=:rby  and entity.mainGold=:mby")
@NamedQuery(name = "FindByMainGold", query = "select entity from FestivalEntity entity where mainGold=:by")
@NamedQuery(name = "FindTotalDaysByName", query = "select entity.totalDays from FestivalEntity entity where entity.name=:by")
@NamedQuery(name = "FindRegionAndMainGoldByName", query = "select entity.region,entity.mainGold from FestivalEntity entity where entity.name=:by")
@NamedQuery(name = "FindRegionAndMainGoldById", query = "select entity.mainGold,entity.totalDays from FestivalEntity entity where entity.id=:by")
@NamedQuery(name = "FindMainGoldAndTotaldaysAndByName", query = "select entity.mainGold,entity.totalDays from FestivalEntity entity where entity.name=:by ")
@NamedQuery(name = "FindTotaldays", query = "select sum(totalDays)from FestivalEntity entity  ")
@NamedQuery(name = "FindMaxTotaldays", query = "select max(entity.totalDays) from FestivalEntity entity   ")
public class FestivalEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "region")
	private String region;
	@Column(name = "totalDays")
	private int totalDays;
	@Column(name = "sweet")
	private String sweet;
	@Column(name = "mainGold")
	private String mainGold;

	public FestivalEntity(String name, String region, int totalDays, String sweet, String mainGold) {
		super();
		this.name = name;
		this.region = region;
		this.totalDays = totalDays;
		this.sweet = sweet;
		this.mainGold = mainGold;
	}

}
