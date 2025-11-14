package com.tca;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Course;
import com.tca.entities.Student;
import com.tca.entities.StudentCourse;


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
        	// I want to assign course-111 to Student-101 
        	
        	Course c=new Course();
        	c.setCid(111);
        	c.setCname("Core-Java");
        	
        	Student s=new Student();
        	s.setRno(101);
        	s.setName("AAA");
        	
        	StudentCourse sc=new StudentCourse();
        	sc.setId(1);
        	sc.setStudent(s);
        	sc.setCourse(c);
        	sc.setRegdate(LocalDate.now());
        
        	session.persist(sc);
        	*/
        
        	
        	/*
        	
   		 // I want to assign Course-222 to Student-101 

        	Course c=new Course();
        	c.setCid(222);
        	c.setCname("Advanced Java");
        	
        	Student student=session.get(Student.class,101);
        	
        	StudentCourse sc=new StudentCourse();
        	sc.setId(2);
        	sc.setCourse(c);
        	sc.setStudent(student);
        	sc.setRegdate(LocalDate.of(2025,5,10));
        	
        	session.persist(sc);
        	*/
        	
        	
        /*	
   		 // Student-102 has taken admisson but dont have any course yet.

        	Student s=new Student();
        	s.setRno(102);
        	s.setName("BBB");
        	session.persist(s);
        	*/
        	
        	/*
    		// Launching course-333 Hibernate but not have admission yet

        	Course c=new Course();
        	c.setCid(333);
        	c.setCname("Hibernate");
        	session.persist(c);
        	*/
        	
        	/*
    		// Student-102 has taken admission for Course-111 Core java 

        	
        	Student s=session.get(Student.class,102);
        	Course c=session.get(Course.class,111);
        	
        	StudentCourse sc=new StudentCourse();
        	sc.setId(3);
        	sc.setStudent(s);
        	sc.setCourse(c);
        	sc.setRegdate(LocalDate.now());
        	session.persist(sc);
        	*/
        	
    		// Student-103 has taken admission for Course-333 Hibernae 

        	/*
        	Student s=new Student();
        	s.setRno(103);
        	s.setName("CCC");
        	
        	Course c=session.get(Course.class,333);
        	
        	StudentCourse sc=new StudentCourse();
        	sc.setId(4);
        	sc.setCourse(c);
        	sc.setStudent(s);
        	sc.setRegdate(LocalDate.now());
        	
        	session.persist(sc);
        	*/
        	
        	
   		 /******************* FETCHING LOGIC *************************/

   		 // I want see courses joined by Student-101
        	/*
        	
        	Student s = session.get(Student.class, 101);
    		
    		System.out.println("Student Roll Number : " + s.getRno());
    		System.out.println("Student Name        : " + s.getName());
    		
    		List<StudentCourse> L = s.getRegis();
    		System.out.println("****** Courses Information *********");
    		
    		for( StudentCourse sc : L)
    		{
    			Course c = sc.getCourse();
    			
    			System.out.println("Course ID         : " +  c.getCid());
    			System.out.println("Course Name       : " +  c.getCname());
    			System.out.println("Registration Date : " + sc.getRegdate());
    			System.out.println("-------------------------------------------");
    		}
        	*/
        	
        	/*

    	    // I want to list of students who has taken admision for course-111  on which date 
    		   
    		   Course C = session.get(Course.class, 111); 
    		 
    		   System.out.println("********Course Information ************"); 
    		   System.out.println("Course ID   : " +  C.getCid()); 
    		   System.out.println("Course Name : " + C.getCname()); 
    		   
    		    System.out.println("******** Student Information **********"); 
    		   
    		        List<StudentCourse> L= C.getRegis(); 
    		         
    		   for(StudentCourse SC : L) 
    		   { 
    		          Student S = SC.getStudent(); 
    		          
    		          System.out.println("Roll Number    : " + S.getRno()); 
    		          System.out.println("Name           : " + S.getName()); 
    		          System.out.println("Registration Date :" + SC.getRegdate()); 
    		          System.out.println(); 
    		    } 
    		   */
        	
    		// Find Student-Course Information whose registration take place on  14th Nov, 2025 

        	LocalDate d=LocalDate.of(2025,11,14);
        	Query<StudentCourse> query=session.createQuery("FROM StudentCourse WHERE regdate=:udate",StudentCourse.class);
        	query.setParameter("udate",d);
        	List<StudentCourse> L=query.getResultList();
        	
        	
        	for(StudentCourse sc:L)
        	{
        		Student s=sc.getStudent();
        		Course c=sc.getCourse();
        		
    			System.out.println("Student " + s.getName() +" has registered for " +c.getCname() +" on Date:"+ sc.getRegdate());

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


