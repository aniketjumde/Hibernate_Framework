package com.tca.service;

import java.util.List;
import java.util.Scanner;

import com.tca.dao.CourseDao;
import com.tca.entity.Course;
import com.tca.factory.CourseDaoFactory;

public class CourseServiceImpl implements CourseService
{

	@Override
	public Integer addCourse(Course course) 
	{
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();
		
		course.setCname(course.getCname().toLowerCase());
	
		return courseDao.saveCourse(course);
	}

	@Override
	public List<Course> fetchAllCourse() 
	{
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();

		return courseDao.fetchAllCourse();
	}

	@Override
	public Course fetchCourseById(Integer Id) 
	{
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();

		return courseDao.fetchCourseById(Id);
	}

	@Override
	public List<Course> fetchCourseByName(String name) 
	{
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();

		return courseDao.fetchCourseByName(name.toLowerCase());
	}

	@Override
	public boolean modifyCourseDetails(Integer Id) 
	{
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();
		Scanner sc=new Scanner(System.in);

		Course course=courseDao.fetchCourseById(Id);
		
		if(course==null )
		{
			return false;
		}
		else
		{
			try
			{
				System.out.print("[ Old Course Name ] : "+course.getCname()+ "   [ New Enter Course Name ] : ");
				String updatedName=sc.nextLine();
				
				System.out.print("[ Old Course fees ] : "+course.getCfees()+ "   [ New Enter Course fees ] : ");
				Double updatedFees=sc.nextDouble();
				
				course.setCname(updatedName);;
				course.setCfees(updatedFees);
				
				boolean status=courseDao.modifyCourseDetails(course);
				return status;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;

			}
		}
	}

	@Override
	public boolean DeleteCourseDetails(Integer Id) 
	{
		CourseDao courseDao=CourseDaoFactory.getCourseDaoInstance();
		
		Course course=courseDao.fetchCourseById(Id);
		
		if(course==null)
		{
			return false;
		}
		else
		{
			return courseDao.DeleteCourse(course);
		}
		
	}


}
