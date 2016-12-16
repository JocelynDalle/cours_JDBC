package com.humanbooster.jdbc.objects;

import java.sql.Date;

public class Basket {

	int id;
	String brand;
	String color;
	float price;
	User user;
	java.sql.Date basket_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public java.sql.Date getBasket_date() {
		return basket_date;
	}

	public void setBasket_date(java.sql.Date basket_date) {
		this.basket_date = basket_date;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", brand=" + brand + ", color=" + color + ", price=" + price + ", login="
				+ user.getLogin() + ", basket_date=" + basket_date + "]";
	}

	public Basket(String brand, String color, float price, User user, Date basket_date) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.user = user;
		this.basket_date = basket_date;
	}

	public Basket(String brand, String color, float price, Date basket_date) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.basket_date = basket_date;
	}
	
	public Basket(int id, String brand, String color, float price, User user, Date basket_date) {
		super();
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.user = user;
		this.basket_date = basket_date;
	}
	
	public Basket(String brand, String color, float price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

}
