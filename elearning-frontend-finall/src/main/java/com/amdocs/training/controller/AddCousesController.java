package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.dao.impl.CouseDAOImpl;
import com.amdocs.training.dao.impl.FeedbackDAOImpl;
import com.amdocs.training.model.Course;
import com.amdocs.training.model.Feedback;

@WebServlet("/addcourse")
public class AddCousesController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	long cid = Long.parseLong(req.getParameter("cid"));
	String username = req.getParameter("name");
	String desp = req.getParameter("desp");
	String fees = req.getParameter("fees");
	String resource = req.getParameter("resource");

	
//	DataSource dataSource = DataSourceUtil.dataSource();
//	Connection conn=null;
//	try {
//		conn = dataSource.getConnection();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	UserDAO dao= new UserDAOImpl();
//	
//	User user = new User(120L, "Pay", "d", "f", "f","f","f", "j");
//	
//	if(conn!=null)
//		out.println("done");
//	else
//		out.println("not done");
	
	Course course= new Course(cid, username, desp, fees, resource);
	
	CourseDAO dao= new CouseDAOImpl();

	boolean addCourse = dao.addCourse(course);
	
	if(addCourse) {
		resp.sendRedirect("courseadddone.html");

	}
	else {
		resp.sendRedirect("trycourseAgain.html");
	}
		
		
	}
	
}
