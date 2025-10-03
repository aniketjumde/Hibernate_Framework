package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Student;

public class App 
{
    public static void main(String[] args) 
    {
    	Configuration configuration=null;
    	SessionFactory sessionFactory=null;
    	Session session=null;
    	Transaction transaction=null;
    	
    	try
    	{
    		configuration=new Configuration();
    		configuration.configure();
    		
    		sessionFactory=configuration.buildSessionFactory();
    		
    		session=sessionFactory.openSession();
    		transaction=session.beginTransaction();
    		
    		
    		
    		 /* Test-Code 1: The Two Student objects are accessing same data in Caching reference are same
    		 * 
    		Student s1=session.get(Student.class,101);
    		Student s2=session.get(Student.class,101);

    		System.out.println(s1);
    		System.out.println(s2);
    		
    		transaction.commit();
    		
    		*/
    		
    	/*
    	 * Test Code 2:
    		
    		//Case : Its Object has its Own cache memory
    		//Threfore same student object has recieved using twi object interaction
    		//Cache of session1 and Cahce of session2 will have same student data but different reference 		
    		Session session1=sessionFactory.openSession();
    		Session session2=sessionFactory.openSession();
    		transaction=session.beginTransaction();

    		Student s1=session1.get(Student.class,101);
    		Student s2=session2.get(Student.class,101);

    		System.out.println(s1);
    		System.out.println(s2);
    		
    		*/
    		
    		/*
    		 * Test Code 3:  evit();
    		 
    		
    		session=sessionFactory.openSession();
    		transaction=session.beginTransaction();

    		Student student=new Student();
    		student.setName("pradeep");
    		student.setPer(82.3);
    		student.setRno(102);
    		
    		session.persist(student);
    		
    		System.out.println(student);
    		
    		session.evict(student);
    		
    		
    		
    		transaction.commit();
    		
    		System.out.println(student);

			*/
    		
    		/*
    		 * Test code : merge
    		 * 
    		 * 
    		 */
    		
    		Student student=session.get(Student.class,101);
  
    		System.out.println(student);
    		
    		session.evict(student);
    		session.merge(student);
    		
    		System.out.println(student);
    		transaction.commit();
    		
    		System.out.println("Work is Done.!!");
    	}
    	catch(Exception e)
    	{
    		transaction.rollback();
    		e.printStackTrace();
    	}
    	
    	finally
    	{
    		//session1.close();
    		sessionFactory.close();
    	}
    }
}
