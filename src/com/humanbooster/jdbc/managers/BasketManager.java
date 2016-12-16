package com.humanbooster.jdbc.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.humanbooster.jdbc.objects.Basket;
import com.humanbooster.jdbc.objects.User;
import com.humanbooster.jdbc.utils.manager.DateUtils;
import com.humanbooster.jdbc.utils.service.DateUtilsService;

public class BasketManager {

	private Connection con;

	public BasketManager(Connection con) {
		this.con = con;
	}

	
	
	public boolean createBasket(Basket basket) {
		String query = "INSERT INTO basket (brand, color, price, login, basket_date) VALUES (?,?,?,?,?)";
		boolean isCreated = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, basket.getBrand());
			ps.setString(2, basket.getColor());
			ps.setFloat(3, basket.getPrice());
			ps.setString(4, basket.getUser().getLogin());
			ps.setDate(5, basket.getBasket_date());
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
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString(5), null);
				Basket basket = new Basket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), u,
						rs.getDate(6));
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
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;

	}

	public int getLastBasketId() {
		String query = "SELECT MAX(id) FROM basket WHERE id";
		int number = -1;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	public Basket getBasketById(int id) {
		String query = "SELECT * FROM basket WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString(5), null);
				Basket basket = new Basket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), u,
						rs.getDate(6));
				return basket;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateBasket(int id, float price, String color) {
		String query = "UPDATE basket SET price = ?, color = ? WHERE id = ?";
		boolean isUpdated = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setFloat(1, price);
			ps.setString(2, color);
			ps.setInt(3, id);
			ps.executeUpdate();
			isUpdated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public List<Basket> getAll() {
		String query = "SELECT * FROM basket";
		List<Basket> lsBasket = new ArrayList<Basket>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString(5), null);
				Basket basket = new Basket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), u,
						rs.getDate(6));
				lsBasket.add(basket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsBasket;
	}

	public boolean deleteBasket(int id) {
		String query = "DELETE FROM basket WHERE id = ?";
		boolean isDeleted = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			isDeleted = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean deleteAll() {
		String query1 = "DELETE FROM basket";
		String query2 = "ALTER TABLE basket AUTO_INCREMENT=1";

		boolean isDeleted = false;
		try {
			PreparedStatement ps = con.prepareStatement(query1);
			ps.executeUpdate();
			ps = con.prepareStatement(query2);
			ps.executeUpdate();
			isDeleted = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean createBaskets(List<Basket> baskets) {
		boolean isCreated = false;

		for (Basket basket : baskets) {
			String query = "INSERT INTO basket (brand, color, price, login, basket_date) VALUES (?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, basket.getBrand());
				ps.setString(2, basket.getColor());
				ps.setFloat(3, basket.getPrice());
				ps.setString(4, basket.getUser().getLogin());
				ps.setDate(5, basket.getBasket_date());
				ps.executeUpdate();
				isCreated = true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		return isCreated;
	}

	public boolean updateBaskets(List<Basket> baskets) {
		boolean isUpdated = false;
		for (Basket basket : baskets) {
			String query = "UPDATE basket SET color = ? WHERE price = ? AND brand = ?";
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, basket.getColor());
				ps.setFloat(2, basket.getPrice());
				ps.setString(3, basket.getBrand());
				ps.executeUpdate();
				isUpdated = true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return isUpdated;
	}
	
	public boolean	createBasketWithUser(Basket basket, User user) {
		
		return true;
	}

	public List<Basket> getBasketAfterDate(Date date) {
		String query = "SELECT * FROM basket WHERE basket_date < ?";
		List<Basket> lsBasket = new ArrayList<Basket>();
		DateUtilsService dus = new DateUtils();

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDate(1, dus.convertUtilDateToSQLDate(date));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString(5), null);
				Basket basket = new Basket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), u,
						rs.getDate(6));
				lsBasket.add(basket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsBasket;
	}

}
