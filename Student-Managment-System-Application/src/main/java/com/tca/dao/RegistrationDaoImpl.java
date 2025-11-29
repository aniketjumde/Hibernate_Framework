package com.tca.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tca.entity.Course;
import com.tca.entity.Registration;
import com.tca.entity.Student;
import com.tca.util.HibernateUtil;

public class RegistrationDaoImpl implements RegistrationDao 
{

	@Override
	public boolean saveRegistration(Student student, Course course) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		
		try(Session session=sessionFactory.openSession();)
		{
			transaction=session.beginTransaction();
			
			Student st = session.get(Student.class, student.getRno());
	        Course cr  = session.get(Course.class, course.getCid());
	        
			Registration registration=new Registration();
			registration.setCourse(cr);
			registration.setStudent(st);
			registration.setRegdate(LocalDate.now());
			
			session.persist(registration);
			
			transaction.commit();
			
			return true;
		}
		catch(Exception e)
		{
			 if (transaction != null) 
			 {
				 transaction.rollback(); 
		     }
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Student> findStudent(Course course) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		try(Session session=sessionFactory.openSession())
		{
	        Course cr = session.get(Course.class, course.getCid());

	        String hql="SELECT student FROM Registration WHERE course=:cr";
			Query<Student> query=session.createQuery(hql,Student.class);
			query.setParameter("cr",cr);
			
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Course> findCourse(Student student) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		try(Session session=sessionFactory.openSession())
		{
			Student st=session.get(Student.class, student.getRno());
			
			String hql="SELECT course FROM Registration Where student=:st";
			
			Query<Course> query=session.createQuery(hql,Course.class);
			query.setParameter("st",st);
			
			return query.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteRegistration(Integer sid, Integer cid) 
	{
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		    Session session = null;
		    Transaction tx = null;

		    try {
		        session = sessionFactory.openSession();
		        tx = session.beginTransaction();

		        // Bulk delete ONLY the registration
		        String hql = "DELETE FROM Registration r WHERE r.student.rno = :sid AND r.course.cid = :cid";

		        int deletedRows = session.createQuery(hql)
		                                 .setParameter("sid", sid)
		                                 .setParameter("cid", cid)
		                                 .executeUpdate();

		        tx.commit();

		        return deletedRows > 0;   // true if deletion happened
		    } 
		    catch (Exception e) 
		    {
		        if (tx != null) tx.rollback();
		        e.printStackTrace();
		        return false;
		    } 
		    finally 
		    {
		        if (session != null) session.close();
		    }
	}



}
