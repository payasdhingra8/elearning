package com.amdocs.training.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DataSourceUtil;

public class UserController {

	
	public static void main( String[] args)
	{

		DataSource dataSource = DataSourceUtil.dataSource();
		
		UserDAO dao= new UserDAOImpl();
		
		List<User> list = new ArrayList<>(); 
				list = dao.findAll();
		
				for(User user:list) {
					System.out.println(user.getId());			
					
				}
				
		
		
	}
	
	
}
