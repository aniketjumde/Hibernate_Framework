package com.tca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tca.entity.Student;
import com.tca.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao 
{
	

	@Override
	public Integer saveStudent(Student student) 
	{

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		try (Session session = sessionFactory.openSession();) 
		{
			transaction = session.beginTransaction();

			session.persist(student);
			Integer id = (Integer) session.getIdentifier(student);

			transaction.commit();
			return id;
		} catch (Exception e) {
			transaction.rollback();
			return null;

		}
	}

	@Override
	public Student findStudentById(Integer Id) 
	{

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try (Session session = sessionFactory.openSession();) 
		{
			Student student = session.get(Student.class, Id);
			return student;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Student> findStudentByName(String name) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try (Session session = sessionFactory.openSession()) 
		{
			Query<Student> query = session.createQuery("FROM Student WHERE name LIKE '%" + name + "%'", Student.class);

			return query.getResultList();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Student> findStudentByCity(String city) 
	{

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try (Session session = sessionFactory.openSession()) 
		{
			Query<Student> query = session.createQuery("FROM Student WHERE city LIKE '%" + city + "%'", Student.class);

			return query.getResultList();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Student> findStudentByPer(Double per) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try (Session session = sessionFactory.openSession();) 
		{
			Query<Student> query = session.createQuery("FROM Student WHERE per=" + per, Student.class);

			return query.getResultList();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Student> fetchAllStudent() 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession();) 
		{
			Query<Student> query = session.createQuery("FROM Student", Student.class);

			return query.getResultList();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean updateStudent(Student student) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		try(Session session=sessionFactory.openSession())
		{
			transaction = session.beginTransaction();
			
			session.merge(student);
			
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteStudent(Student student) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		try(Session session=sessionFactory.openSession();)
		{
			transaction=session.beginTransaction();
			session.remove(student);
			
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
