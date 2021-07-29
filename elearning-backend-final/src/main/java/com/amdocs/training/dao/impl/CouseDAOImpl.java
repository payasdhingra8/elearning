package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.model.Course;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DataSourceUtil;

public class CouseDAOImpl implements CourseDAO{

	DataSource dataSource = DataSourceUtil.dataSource();
	
	@Override
	public List<Course> findAll() {
		List<Course> courses = new ArrayList<Course>();
		String sql = "select * from course";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long cId = rs.getLong("course_id");
				String cName = rs.getString("c_name");
				String cDesp = rs.getString("c_desp");
				String cFees = rs.getString("c_fees");
				String cResouces = rs.getString("c_resource");
		
				Course course = new Course(cId,cName,cDesp,cFees,cResouces);

				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addCourse(Course course) {
		String query = "insert into course values(?,?,?,?,?)";

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, course.getcId());
			ps.setString(2, course.getcName());
			ps.setString(3, course.getcDesp());
			ps.setString(4, course.getcFees());
			ps.setString(5, course.getcResources());
		
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteCourse(Long id) {
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			int executeUpdate = stmt.executeUpdate("DELETE FROM course WHERE course_id=" + id);
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
	

}
