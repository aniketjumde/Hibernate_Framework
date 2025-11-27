package com.tca.service;

import java.util.List;

import com.tca.entity.Course;
import com.tca.entity.Student;

public interface RegistrationService 
{
	public abstract boolean addRegistration(Integer id, Integer cid);
	public abstract List<Student> fetchStudent(Integer cid);// Find student for registed Course 
	public abstract List<Course>  fetchCourse(Integer sid);
	public abstract boolean removeRegistration(Integer id,Integer cid);
	
}
