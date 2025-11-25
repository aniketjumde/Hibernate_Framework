package com.tca.dao;

import java.util.List;

import com.tca.entity.Student;

public interface StudentDao 
{
	abstract public Integer saveStudent(Student student);
	abstract public Student findStudentById(Integer Id);
	abstract public List<Student> findStudentByName(String name);
	abstract public List<Student> findStudentByCity(String city);
	abstract public List<Student> findStudentByPer(Double per);
	abstract public List<Student> fetchAllStudent();
	abstract public boolean updateStudent(Student student);
	abstract public boolean deleteStudent(Student student);
}
