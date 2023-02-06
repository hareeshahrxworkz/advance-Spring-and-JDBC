package com.xworkz.hareesha.dto;

public class EducationDTO{

	private String name;
	private String location;
	private String area;
	private String type;
	private int year;
	private String distic;
	private String pincode;
	private String passesdout;
	private String courseName;
	private String collegeName;

	public EducationDTO() {
		System.out.println("Running " + getClass().getSimpleName());
	}

	public EducationDTO(String name, String location, String area, String type, int year, String distic, String pincode,
			String passesdout, String courseName, String collegeName) {
		super();
		this.name = name;
		this.location = location;
		this.area = area;
		this.type = type;
		this.year = year;
		this.distic = distic;
		this.pincode = pincode;
		this.passesdout = passesdout;
		this.courseName = courseName;
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "Educationchat [name=" + name + ", location=" + location + ", area=" + area + ", type=" + type + ", year="
				+ year + ", distic=" + distic + ", pincode=" + pincode + ", passesdout=" + passesdout + ", courseName="
				+ courseName + ", collegeName=" + collegeName + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDistic() {
		return distic;
	}

	public void setDistic(String distic) {
		this.distic = distic;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPassesdout() {
		return passesdout;
	}

	public void setPassesdout(String passesdout) {
		this.passesdout = passesdout;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}
