package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Course;
import com.tca.entities.Student;


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
        	
        	/*
        	 * Add two course and assign to one Student
        	 * 
        	 * 
        	Course c1=new Course();
        	c1.setCid(111);
        	c1.setCname("Core Java");
        	
        	Course c2=new Course();
        	c2.setCid(222);
        	c2.setCname("Advanced Java");
        	
        	Student s=new Student();
        	s.setRno(101);
        	s.setName("AAA");
        	s.setCourse(Arrays.asList(c1,c2));
        	
        	 session.persist(s);

        	
        	*/
        	
        	
        	
        	
        	/*
        	//Execting Course is assigning to new Student
        	
        	//Course c=session.get(Course.class,111);
        	
        	Student s=new Student();
        	s.setRno(102);
        	s.setName("BBB");
        	//s.setCourse(Arrays.asList(c));
        	s.setCourse(Arrays.asList(session.get(Course.class,111)));
        	session.persist(s);
        	*/
        	/*
        	Course c=new Course();
        	c.setCid(333);
        	c.setCname("Hibernate");
        	
        	Student s=new Student();
        	s.setRno(103);
        	s.setName("CCC");
        	s.setCourse(Arrays.asList(c));
        	
        	session.persist(s);
        	*/
        	
        	/*
        	//Fetch The Record on the basic of Course
        	//How many student are enrolled in Advanced Java Course
        	
        	Course c=session.get(Course.class,111);
        	
        	System.out.println("Course Id   : "+c.getCid());
        	System.out.println("Course name : "+c.getCname());
        	
        	for(Student s: c.getStudent())
        	{
        		System.out.println("Student rno  : "+s.getRno());
        		System.out.println("Student name : "+s.getName());
            	System.out.println();


        	}
        	
        	*/
        	
        	
        	//
        	//Student 101 How many Course is Enrolled?
        	
        	Student s=session.get(Student.class,101);
        	System.out.println("Student rno  : "+s.getRno());
        	System.out.println("Student name : "+s.getName());
        	
        	for(Course c:s.getCourse())
        	{
        		System.out.println("Course id :"+c.getCid());
        		System.out.println("Course name :"+c.getCname());
        	}
        	
        	transaction.commit();
        	System.out.print("Work is Done .!!!");
        }
        catch(Exception e)
        {
        	if(transaction!=null)
        	{
        		transaction.rollback();
        	}
        	e.printStackTrace();
        }
        
    }
}


