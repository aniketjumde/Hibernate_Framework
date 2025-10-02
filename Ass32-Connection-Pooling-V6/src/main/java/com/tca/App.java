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
        	student.setRno(101);
        	student.setName("Pradeep");
        	student.setPer(79.2);
        	
        	session.save(student);
        	
        	transaction.commit();
        	
        	System.out.println("Record is Saved Successfully. !!!");
        
        }
        catch(Exception e)
        {
        	transaction.rollback();
        	e.printStackTrace();
        }
        
        finally
        {
        	session.close();
        	sessionFactory.close();
        }
    }
}
