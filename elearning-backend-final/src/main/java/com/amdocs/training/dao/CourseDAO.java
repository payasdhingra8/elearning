package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Course;
import com.amdocs.training.model.User;

public interface CourseDAO {

	List<Course> findAll();

	boolean addCourse(Course course);

	boolean deleteCourse(Long id);
	

}
