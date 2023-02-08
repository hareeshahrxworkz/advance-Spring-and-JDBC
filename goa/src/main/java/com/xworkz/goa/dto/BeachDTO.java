package com.xworkz.goa.dto;

public class BeachDTO{

	private String name;
	private String location;
	private String clean;
	private String game;

	public BeachDTO() {
		System.out.println("running : " + getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "Beachchat [name=" + name + ", location=" + location + ", clean=" + clean + ", game=" + game + "]";
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

	public String getClean() {
		return clean;
	}

	public void setClean(String clean) {
		this.clean = clean;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
	
	
	
	
}
