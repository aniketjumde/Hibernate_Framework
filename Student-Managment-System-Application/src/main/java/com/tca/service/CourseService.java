package com.tca.service;

import java.util.List;

import com.tca.entity.Course;

public interface CourseService 
{
	abstract public Integer addCourse(Course course);
	abstract public List<Course> fetchAllCourse();
	abstract public Course fetchCourseById(Integer Id);
	abstract public List<Course> fetchCourseByName(String name);
	abstract public boolean modifyCourseDetails(Integer Id);
	abstract public boolean DeleteCourseDetails(Integer Id);
	

}
