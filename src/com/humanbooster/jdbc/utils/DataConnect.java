package com.humanbooster.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cours_jdbc", "root", "");
		return connection;
	}

	public static void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
