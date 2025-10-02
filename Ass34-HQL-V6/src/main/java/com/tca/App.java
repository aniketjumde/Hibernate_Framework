package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
        	
        	/*
        	// Test-Code : Display all records  with all Column
        	
        	Query<Student> query=session.createQuery("From Student",Student.class); //SELECT * FROM Student
        	
        	List<Student> list=query.list(); //Query is Fired
        	
        	for(Student s:list)
        	{
        		System.out.println("Roll No    : "+s.getRno());
        		System.out.println("Name   	   : "+s.getName());
        		System.out.println("Percentage : "+s.getPer());
        		System.out.println("City       : "+s.getCity());
        		System.out.println("---------------------------------------");
        	}
        	*/
        	
        	
        	// Test-Code : Display all records  with SPECIFIC COLUMN
        	
        	Query<Object[]> query=session.createQuery("SELECT name,city FROM Student",Object[].class);
        	
        	List<Object[]> list=query.list();
        	
        	for(Object[] ob:list)
        	{
        		for(Object data:ob)
        		{
        			System.out.print(data+" ");
        		}
        		System.out.println();
        	}
        	
        	transaction.commit();
        	System.out.println("Work is Done.!!!");
		}
		catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
        finally
        {
        	session.close();
			sessionFactory.close();
			
		}
    }
}
