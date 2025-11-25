package com.tca.service;

import java.util.List;

import com.tca.entity.Student;

public interface StudentService 
{
	abstract public Integer addStudent(Student student);
	abstract public Student fetchStudentById(Integer Id);
	abstract public List<Student> fetchStudentByName(String name);
	abstract public List<Student> fetchStudentByCity(String city);
	abstract public List<Student> fetchStudentByPer(Double per);
	abstract public List<Student> fetchAllStudent();
	abstract public boolean modifyStudent(Integer Id);
	abstract public boolean removeStudent(Integer Id);
}
