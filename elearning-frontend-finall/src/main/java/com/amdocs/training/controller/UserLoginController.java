package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

@WebServlet("/login")
public class UserLoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		long id = Long.parseLong(req.getParameter("id"));
		String password = req.getParameter("password");
		
		UserDAO dao= new UserDAOImpl();
		User user= dao.getUserById(id);
	
		if(user.getPassword().equals(password))
		{
			resp.sendRedirect("ChooseUser.html");
		}
		else
			resp.sendRedirect("tryAgainUser.html");
	
	}
	
}
