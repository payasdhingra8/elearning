package com.amdocs.training.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.dao.impl.FeedbackDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.Feedback;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DataSourceUtil;

public class FeedbackController {

	public static void main( String[] args)
	{
		DataSource dataSource = DataSourceUtil.dataSource();
		
		FeedbackDAO dao= new FeedbackDAOImpl();
		
		List<Feedback> list = new ArrayList<>(); 
				list = dao.findAll();
		
				for(Feedback feedback:list) {
					System.out.println(feedback.getFeedbackId());			
					
				}
}
}
