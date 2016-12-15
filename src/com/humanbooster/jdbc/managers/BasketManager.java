package com.humanbooster.jdbc.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.humanbooster.jdbc.objects.Basket;

public class BasketManager {

	private Connection con;

	public BasketManager(Connection con) {
		this.con = con;
	}

	public boolean createBasket(Basket basket) {
		String query = "INSERT INTO basket (brand, color, price, login, basket_date) VALUES (?,?,?,?,?)";
		boolean isCreated = false;
		try {
			System.out.println(query);

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, basket.getBrand());
			ps.setString(2, basket.getColor());
			ps.setFloat(3, basket.getPrice());
			ps.setString(4, basket.getLogin());
			ps.setDate(5, basket.getBasket_date());
			System.out.println(ps);
			ps.executeUpdate();
			isCreated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	
	
	public List<Basket> findBasket(String brand) {
		String query = "SELECT * FROM basket WHERE brand = ?";
		List<Basket> lsBasket = new ArrayList<Basket>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, brand);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Basket basket = new Basket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getDate(6));
				lsBasket.add(basket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsBasket;
	}
	
	public int getNumberOfBasket() {
		String query = "SELECT COUNT(*) FROM basket";
		int number = -1;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;

	}
}
