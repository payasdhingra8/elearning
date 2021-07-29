package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DBUtil;
import com.amdocs.training.util.DataSourceUtil;

public class UserDAOImpl implements UserDAO {

	DataSource dataSource = DataSourceUtil.dataSource();

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from user";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long id = rs.getLong("user_id");
				String name = rs.getString("username");
				String phone = rs.getString("phone_no");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String regDate = rs.getString("reg_date");
				String password = rs.getString("password");
				String photo = rs.getString("upload_photo");

				User user = new User(id, name, phone, email, address, regDate, password, photo);

				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {

		String query = "insert into user values(?,?,?,?,?,?,?,?)";

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getRegDate());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getPhoto());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public User getUserById(Long id) {

		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE user_id=" + id);

			if (rs.next()) {
				long userId = rs.getLong("user_id");
				String name = rs.getString("username");
				String phone = rs.getString("phone_no");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String date = rs.getString("reg_date");
				String password = rs.getString("password");
				String photo = rs.getString("upload_photo");

				User user = new User(userId, name, phone, email, address, date, password, photo);
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean deleteUser(Long id) {
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			int executeUpdate = stmt.executeUpdate("DELETE FROM user WHERE user_id=" + id);
			if (executeUpdate > 0) {
				System.out.println("Deleted Succesfully!!");
			} else {
				System.out.println("Try Again!!");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateUser(User user) {

		String sql = "update user set password=?  where user_id = ?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(2, user.getId());
			ps.setString(1, user.getPassword());
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("Employee updated Successfully");
			} else {
				System.out.println("Try Again!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
