package com.xworkz.hareesha.dto;

public class FamilyDTO {
	private String name;
	private String fatherName;
	private String motherName;
	private String sisterName;
	private String nativeName;
	private String distic;
	private String place;
	private String surname;
	private String grandFatherName;

	public FamilyDTO() {
		System.out.println("Running Familychat");
	}

	@Override
	public String toString() {
		return "Familychat [name=" + name + ", fatherName=" + fatherName + ", motherName=" + motherName + ", sisterName="
				+ sisterName + ", nativeName=" + nativeName + ", distic=" + distic + ", place=" + place + ", surname="
				+ surname + ", grandFatherName=" + grandFatherName + "]";
	}

	public FamilyDTO(String name, String fatherName, String motherName, String sisterName, String nativeName,
			String distic, String place, String surname, String grandFatherName) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.sisterName = sisterName;
		this.nativeName = nativeName;
		this.distic = distic;
		this.place = place;
		this.surname = surname;
		this.grandFatherName = grandFatherName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getSisterName() {
		return sisterName;
	}

	public void setSisterName(String sisterName) {
		this.sisterName = sisterName;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	public String getDistic() {
		return distic;
	}

	public void setDistic(String distic) {
		this.distic = distic;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGrandFatherName() {
		return grandFatherName;
	}

	public void setGrandFatherName(String grandFatherName) {
		this.grandFatherName = grandFatherName;
	}

}
