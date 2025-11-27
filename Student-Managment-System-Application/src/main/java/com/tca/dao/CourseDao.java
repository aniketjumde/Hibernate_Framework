package com.tca.dao;

import java.util.List;

import com.tca.entity.Course;

public interface CourseDao 
{
	abstract public Integer saveCourse(Course course);
	abstract public List<Course> fetchAllCourse();
	abstract public Course fetchCourseById(Integer Id);
	abstract public List<Course> fetchCourseByName(String name);
	abstract public boolean modifyCourseDetails(Course course);
	abstract public boolean DeleteCourse(Course course);


}
