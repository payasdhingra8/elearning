package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DataSourceUtil;

@WebServlet("/register")
public class RegistrationController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	long id = Long.parseLong(req.getParameter("id"));
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	String phone = req.getParameter("phone");
	String regDate = req.getParameter("date");////////////////
	String email = req.getParameter("email");
	String address = req.getParameter("address");
	String photo = req.getParameter("photo");
	
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
	
	User user= new User(id, username, phone, email, address, regDate, password, photo);
	
	UserDAO dao= new UserDAOImpl();

	boolean addUser = dao.addUser(user);
	
	if(addUser) {
		resp.sendRedirect("UserAddConformation.html");

	}
	else {
		resp.sendRedirect("tryAgainUser.html");
	}
		
		
	}
	
	
}
