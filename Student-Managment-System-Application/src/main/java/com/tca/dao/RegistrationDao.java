package com.tca.dao;

import java.util.List;

import com.tca.entity.Course;
import com.tca.entity.Student;

public interface RegistrationDao 
{
	public abstract boolean saveRegistration(Student student, Course course);
	public abstract List<Student> findStudent(Course course);
	public abstract List<Course>  findCourse(Student student);
	public abstract boolean deleteRegistration(Integer id, Integer cid); 


}
