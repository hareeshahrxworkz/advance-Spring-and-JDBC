package com.xworkz.hareesha.dto;

public class ChatDTO{
	private String name;
	private String contactname;
	private long contactNo;
	private String personName;
	private String chatType;
	private String chatHistory;
	private String chatingAppName;
	private boolean network;
	private String charge;
	private boolean live;

	public ChatDTO() {
		System.out.println("Running " + getClass().getSimpleName());
	}

	public ChatDTO(String name, String contactname, long contactNo, String personName, String chatType,
			String chatHistory, String chatingAppName, boolean network, String charge, boolean live) {
		super();
		this.name = name;
		this.contactname = contactname;
		this.contactNo = contactNo;
		this.personName = personName;
		this.chatType = chatType;
		this.chatHistory = chatHistory;
		this.chatingAppName = chatingAppName;
		this.network = network;
		this.charge = charge;
		this.live = live;
	}


	@Override
	public String toString() {
		return "Chatchat [name=" + name + ", contactname=" + contactname + ", contactNo=" + contactNo + ", personName="
				+ personName + ", chatType=" + chatType + ", chatHistory=" + chatHistory + ", chatingAppName="
				+ chatingAppName + ", network=" + network + ", charge=" + charge + ", live=" + live + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	public String getChatHistory() {
		return chatHistory;
	}

	public void setChatHistory(String chatHistory) {
		this.chatHistory = chatHistory;
	}

	public String getChatingAppName() {
		return chatingAppName;
	}

	public void setChatingAppName(String chatingAppName) {
		this.chatingAppName = chatingAppName;
	}

	public boolean isNetwork() {
		return network;
	}

	public void setNetwork(boolean network) {
		this.network = network;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
