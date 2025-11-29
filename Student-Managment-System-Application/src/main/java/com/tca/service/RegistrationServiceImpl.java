package com.tca.service;

import java.util.List;

import com.tca.dao.CourseDao;
import com.tca.dao.RegistrationDao;
import com.tca.dao.StudentDao;
import com.tca.entity.Course;
import com.tca.entity.Student;
import com.tca.factory.CourseDaoFactory;
import com.tca.factory.RegistrationDaoFactory;
import com.tca.factory.StudentDaoFactory;

public class RegistrationServiceImpl implements RegistrationService
{

	@Override
	public boolean addRegistration(Integer id, Integer cid) 
	{
		RegistrationDao registrationDao=RegistrationDaoFactory.getRegistrationDaoInstance();
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();
		
		Student student=studentDao.findStudentById(id);
		Course course=courseDao.fetchCourseById(cid);
		
		if(student==null || course==null)
		{
			return false;
		}
		else
		{
			return registrationDao.saveRegistration(student, course);
		}
		
	}

	@Override
	public List<Student> fetchStudent(Integer cid) 
	{
		RegistrationDao registrationDao=RegistrationDaoFactory.getRegistrationDaoInstance();
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();
		
		Course course=courseDao.fetchCourseById(cid);
		
		if(course==null)
		{
			return null;
		}
		else
		{
			return registrationDao.findStudent(course);
		}
		
	}

	@Override
	public List<Course> fetchCourse(Integer sid) 
	{
		RegistrationDao registrationDao=RegistrationDaoFactory.getRegistrationDaoInstance();
		StudentDao studentDao=StudentDaoFactory.getStudentDaoInstance();

		
		Student student=studentDao.findStudentById(sid);
		
		if(student==null)
		{
			return null;
		}
		else
		{
			return registrationDao.findCourse(student);
		}
	}

	@Override
	public boolean removeRegistration(Integer id, Integer cid) 
	{
		RegistrationDao registrationDao=RegistrationDaoFactory.getRegistrationDaoInstance();
		
			return registrationDao.deleteRegistration(id, cid);
		

	}

}
