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
        	
    		Query<Student> query = session.createQuery("FROM Student", Student.class);
        	
        	query.setMaxResults(3);
        	
        	for(int i=0;i<10;i=i+3)
        	{
        		query.setFirstResult(i);
        		
    			List<Student> L = query.list();

        		
        		for(Student s: L)
        		{
        			System.out.println("Roll Number : " + s.getRno());
        			System.out.println("Name        : " + s.getName());
        			System.out.println("Percentage  : " + s.getPer());
        			System.out.println("City        : " + s.getCity());
        			System.out.println("-----------------------------------------");
        		}
        		
        		System.out.println("Press Any Key for Continue :");
        		System.in.read();
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
