package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Feedback;
import com.amdocs.training.model.User;

public interface FeedbackDAO {

	List<Feedback> findAll();

	boolean addFeedback(Feedback feedback);

	//Feedback getFeedbackById(Long id);

	
	
	
}
