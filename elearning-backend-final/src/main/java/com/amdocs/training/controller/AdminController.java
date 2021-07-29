package com.amdocs.training.controller;

import javax.sql.DataSource;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DataSourceUtil;

public class AdminController {

	public static void main( String[] args)
	{
	DataSource dataSource = DataSourceUtil.dataSource();
	
	AdminDAO dao= new AdminDAOImpl();
	
	Admin admin = dao.getAdminById(1L);
			
	System.out.println(admin);
}
}