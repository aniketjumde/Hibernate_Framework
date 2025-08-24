package com.tca;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null; //DML Queries Insert,Delete,Update
        
        try
        {
        	configuration=new Configuration();
        	configuration.configure();  //load & parse XML
        	sessionFactory=configuration.buildSessionFactory();
        	session=sessionFactory.openSession();
        	transaction=session.beginTransaction();
        	
        	Student student= session.load(Student.class,101);// Student :[101,"AAA",87.2]
        	
        	
        	
        	session.delete(student);
        	
        	
        	transaction.commit(); //Whatever DB operation performed should be get persisted
        	//permently(Save data in a database permently)
        	
        	System.out.println("Record is Deleted Succesfully.!!");
        }
        catch(Exception e)
        {
        	if(transaction != null) {
        		transaction.rollback();
        	}
        	e.printStackTrace();
        }
        
        finally
        {
        	session.close();
        	sessionFactory.close(); //JDBC con Close()
        	
        }
        
    }
}
