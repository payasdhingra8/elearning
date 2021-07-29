package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

@WebServlet("/table")
public class UserTableController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO dao = new UserDAOImpl();
		List<User> list = new ArrayList<>();
				list = dao.findAll();
		
		PrintWriter out= resp.getWriter();
		
		
		for(User user:list) {
		out.print(user);
		out.println(" ");
			
		}
		
		
	}
	
	
}
