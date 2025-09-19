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
    		
    		
    		Student student=new Student();
    		student.setName("pradeep");
    		student.setPer(75.78);
    		
    		Integer rno=(Integer)session.save(student);
    		
    		System.out.println("Record is Saved Successfully with Roll No :"+rno);
    		transaction.commit();
    		
    		
    	}
    	catch(Exception e)
    	{
    		if(transaction !=null)
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
