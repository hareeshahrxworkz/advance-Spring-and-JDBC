package com.xworkz.goa.dto;

public class CasinoDTO {

	private String name;
	private String cruise;
	private double fee;
	private String food;
	private String alcohol;

	public CasinoDTO() {
		System.out.println("Running : " + getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "Casino [name=" + name + ", cruise=" + cruise + ", fee=" + fee + ", food=" + food + ", alcohol="
				+ alcohol + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCruise() {
		return cruise;
	}

	public void setCruise(String cruise) {
		this.cruise = cruise;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

}
