package com.amdocs.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection connection = null;

	private DBUtil() {
	}

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/elearning";
		String user = "root";
		String password = "payas";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (connection == null) {
				connection = DriverManager.getConnection(url, user, password);
			}
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
