package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DataSourceUtil;

public class AdminDAOImpl implements AdminDAO{
	
	DataSource dataSource = DataSourceUtil.dataSource();

	@Override
	public Admin getAdminById(Long id) {
		
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM admin WHERE admin_id=" + id);

			if (rs.next()) {
				long userId = rs.getLong("admin_id");
				String name = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				Admin admin = new Admin(userId, name, email, password);
				return admin;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;

	}

	
	
	
	
	
}
