package com.xworkz.hareesha.dto;

public class MobileDTO {
	private String name;
	private String company;
	private int releseYear;
	private String nation;
	private String manufaturDate;

	public MobileDTO() {
		System.out.println("Running " + getClass().getSimpleName());
	}

	public MobileDTO(String name, String company, int releseYear, String nation, String manufaturDate) {
		super();
		this.name = name;
		this.company = company;
		this.releseYear = releseYear;
		this.nation = nation;
		this.manufaturDate = manufaturDate;
	}

	@Override
	public String toString() {
		return "Mobilechat [name=" + name + ", company=" + company + ", releseYear=" + releseYear + ", nation=" + nation
				+ ", manufaturDate=" + manufaturDate + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getReleseYear() {
		return releseYear;
	}

	public void setReleseYear(int releseYear) {
		this.releseYear = releseYear;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getManufaturDate() {
		return manufaturDate;
	}

	public void setManufaturDate(String manufaturDate) {
		this.manufaturDate = manufaturDate;
	}

}
