package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.FeedbackDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Feedback;
import com.amdocs.training.model.User;

@WebServlet("/feedback")
public class GiveFeedbackController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	long fid = Long.parseLong(req.getParameter("f_id"));
	long id = Long.parseLong(req.getParameter("id"));
	String username = req.getParameter("username");
	String email = req.getParameter("email");
	String feedbackMsg = req.getParameter("feedback");

	
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
	
	Feedback feedback= new Feedback(id, username, email, fid, feedbackMsg);
	
	FeedbackDAO dao= new FeedbackDAOImpl();

	boolean addFeedback = dao.addFeedback(feedback);
	
	if(addFeedback) {
		resp.sendRedirect("feedbackdone.html");

	}
	else {
		resp.sendRedirect("tryFeedbackAgain.html");
	}
		
		
	}
	
	
	
	
}
