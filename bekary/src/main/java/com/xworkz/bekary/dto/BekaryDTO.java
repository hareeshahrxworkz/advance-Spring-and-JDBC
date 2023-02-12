package com.xworkz.bekary.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bekary_table")
public class BekaryDTO {
	@Column(name = "id")
	@Id
	private int id;
	@Column(name = "b_name")
	private String bekary;
	@Column(name = "b_owneName")
	private String owner;
	@Column(name = "b_wifeName")
	private String wife;
	@Column(name = "b_marrid")
	private boolean married;
	@Column(name = "b_famous")
	private String famous;
	@Column(name = "b_since")
	private int since;

	public BekaryDTO() {
		System.out.println("Running BekaryDTO");
	}

	@Override
	public String toString() {
		return "BekaryDTO [bekary=" + bekary + ", owner=" + owner + ", wife=" + wife + ", married=" + married
				+ ", famous=" + famous + ", since=" + since + "]";
	}

	public String getBekary() {
		return bekary;
	}

	public void setBekary(String bekary) {
		this.bekary = bekary;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getWife() {
		return wife;
	}

	public void setWife(String wife) {
		this.wife = wife;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getFamous() {
		return famous;
	}

	public void setFamous(String famous) {
		this.famous = famous;
	}

	public int getSince() {
		return since;
	}

	public void setSince(int since) {
		this.since = since;
	}

}
