package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.model.Feedback;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DataSourceUtil;

public class FeedbackDAOImpl implements FeedbackDAO{


	DataSource dataSource = DataSourceUtil.dataSource();
	
	@Override
	public List<Feedback> findAll() {
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		String sql = "select * from feedback";
		
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long userId = rs.getLong("user_id");
				String name = rs.getString("username");
				String email = rs.getString("email");
				long feedbackId = rs.getLong("f_id");
				String feedbackMsg = rs.getString("feedback");


				Feedback feedback = new Feedback(userId, name, email, feedbackId, feedbackMsg);

				feedbacks.add(feedback);
			}
			return feedbacks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean addFeedback(Feedback feedback) {
		
		String query = "insert into feedback values(?,?,?,?,?)";

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, feedback.getUserId());
			ps.setString(2, feedback.getUsername());
			ps.setString(3, feedback.getEmail());
			ps.setLong(4, feedback.getFeedbackId());
			ps.setString(5, feedback.getFeedback());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
