package com.xworkz.bekary.dto;

public class BekaryDTO {
	private String bekary;
	private String owner;
	private String wife;
	private boolean married;
	private String famous;
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
