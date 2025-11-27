package com.tca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tca.entity.Course;
import com.tca.util.HibernateUtil;

public class CourseDaoImpl implements CourseDao
{

	@Override
	public Integer saveCourse(Course course) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		
		try(Session session=sessionFactory.openSession();)
		{
			transaction=session.beginTransaction();
			
			session.persist(course);
			Integer id=(Integer) session.getIdentifier(course);
			
			return id;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Course> fetchAllCourse() 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		try(Session session=sessionFactory.openSession())
		{
			Query<Course> query=session.createQuery("FROM Course ",Course.class);
			
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
				
	}

	@Override
	public Course fetchCourseById(Integer Id) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

		try(Session session=sessionFactory.openSession())
		{
				Course course=session.get(Course.class, Id);
				return course;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Course> fetchCourseByName(String name) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

		try(Session session=sessionFactory.openSession())
		{
			Query<Course> query=session.createQuery("FROM Course WHERE cname LIKE :keyname",Course.class);
			query.setParameter("keyname", "%"+name+"%");
			
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public boolean modifyCourseDetails(Course course) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		
		try(Session session=sessionFactory.openSession();)
		{
			transaction=session.beginTransaction();
			
			session.merge(course);
			
			transaction.commit();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean DeleteCourse(Course course) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		
		try(Session session=sessionFactory.openSession();)
		{
			transaction=session.beginTransaction();
			
			session.remove(course);
			
			transaction.commit();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
