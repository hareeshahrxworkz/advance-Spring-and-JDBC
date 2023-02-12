package com.xworkz.foodOrder.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderhotel")

public class OrderDTO {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "h_name")
	private String hotelName;
	@Column(name = "h_place")
	private String place;
	@Column(name = "h_item")
	private String items;
	@Column(name = "h_price")
	private Double price;
	@Column(name = "h_quantity")
	private Integer quantity;
	@Column(name = "type")
	private Boolean takeAway;

	public OrderDTO() {
		System.out.println("Order DTO Running");
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", hotelName=" + hotelName + ", place=" + place+ ", items=" + items + ", price="
				+ price + ", quantity=" + quantity + ", takeAway=" + takeAway + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getTakeAway() {
		return takeAway;
	}

	public void setTakeAway(Boolean takeAway) {
		this.takeAway = takeAway;
	}

}
