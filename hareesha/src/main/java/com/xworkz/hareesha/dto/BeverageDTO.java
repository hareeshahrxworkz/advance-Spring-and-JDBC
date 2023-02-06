package com.xworkz.hareesha.dto;

public class BeverageDTO {
	private String name;
	private String row;
	private String ManufacturName;
	private String modelNo;
	private int contactno;
	private String ShopeName;
	private String state;

	public BeverageDTO() {
		System.out.println("Running " + getClass().getSimpleName());
	}

	public BeverageDTO(String name, String row, String manufacturName, String modelNo, int contactno, String shopeName,
			String state) {
		super();
		this.name = name;
		this.row = row;
		ManufacturName = manufacturName;
		this.modelNo = modelNo;
		this.contactno = contactno;
		ShopeName = shopeName;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Beveragechat [name=" + name + ", row=" + row + ", ManufacturName=" + ManufacturName + ", modelNo="
				+ modelNo + ", contactno=" + contactno + ", ShopeName=" + ShopeName + ", state=" + state + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getManufacturName() {
		return ManufacturName;
	}

	public void setManufacturName(String manufacturName) {
		ManufacturName = manufacturName;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public int getContactno() {
		return contactno;
	}

	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	public String getShopeName() {
		return ShopeName;
	}

	public void setShopeName(String shopeName) {
		ShopeName = shopeName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
