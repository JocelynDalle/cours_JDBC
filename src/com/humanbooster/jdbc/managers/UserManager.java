package com.humanbooster.jdbc.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.humanbooster.jdbc.objects.User;
import com.humanbooster.jdbc.service.UserService;

public class UserManager  implements UserService {

	private Connection con;

	public UserManager(Connection con) {
		this.con = con;
	}


	public boolean deleteAllEntries() {
		String query = "DELETE FROM user";
		boolean isOk = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.execute();
			System.out.println(ps);
			isOk = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isOk;
	}

	public boolean createUser(User u) {
		String query = "INSERT INTO user VALUES (?,?)";
		boolean isCreated = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ps.executeUpdate();
			System.out.println(ps);
			isCreated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	
	
	
	public boolean createUserDirty(User u) {
		String query = "INSERT INTO user VALUES ('" + u.getLogin() + "','" + u.getPassword() + "')";
		boolean isCreated = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println(ps);
			ps.executeUpdate();
			isCreated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	
	
	
	public User getUser(String login) {
		User user = null;
		String query = "SELECT * FROM user WHERE login = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, login);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				;
			user = new User(rs.getString(1), rs.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	
	
	
	public User getUserDirty(String login) {
		User user = null;
		String query = "SELECT * FROM user WHERE login = '" + login + "'";
		try {
			Statement stmt = con.createStatement();
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next())
				;
			user = new User(rs.getString(1), rs.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	
	
	
	public boolean updateUser(String login, String password) {
		boolean updateOk = false;
		String query = "UPDATE user SET password = ? WHERE login = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, login);
			System.out.println(ps);
			ps.execute();
			updateOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updateOk;
	}

	
	
	public boolean updateUserDirty(String login, String password) {
		boolean updateOk = false;
		String query = "UPDATE user SET password = '" + password + "' WHERE login = '" + login + "'";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println(ps);
			ps.execute();
			updateOk = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updateOk;
	}

	
	
	public boolean deleteUser(String login) {
		String query = "DELETE FROM user WHERE login = ?";
		boolean isOk = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, login);
			System.out.println(ps);
			ps.execute();
			isOk = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isOk;
	}

	
	
	public boolean deleteUserDirty(String login) {
		boolean isOk = false;
		String query = "DELETE FROM user WHERE login = '" + login + "'";
		try {
			Statement stmt = con.createStatement();
			stmt.execute(query);
			System.out.println(stmt);
			isOk = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isOk;
	}


}
