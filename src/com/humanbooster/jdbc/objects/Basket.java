package com.humanbooster.jdbc.objects;

import java.sql.Date;

public class Basket {

	int id;
	String brand;
	String color;
	float price;
	String login;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public java.sql.Date getBasket_date() {
		return basket_date;
	}

	public void setBasket_date(java.sql.Date basket_date) {
		this.basket_date = basket_date;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", brand=" + brand + ", color=" + color + ", price=" + price + ", login=" + login
				+ ", basket_date=" + basket_date + "]";
	}

	public Basket(String brand, String color, float price, String login, Date basket_date) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.login = login;
		this.basket_date = basket_date;
	}

	public Basket(int id, String brand, String color, float price, String login, Date basket_date) {
		super();
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.login = login;
		this.basket_date = basket_date;
	}
	
}
