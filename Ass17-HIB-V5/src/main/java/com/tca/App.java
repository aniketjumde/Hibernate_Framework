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
       Transaction transaction=null;
       
       try
       {
    	   configuration =new Configuration();
    	   configuration.configure();
    	   sessionFactory=configuration.buildSessionFactory();
    	   session=sessionFactory.openSession();
    	   transaction=session.beginTransaction();
    	   
    	   Student student=new Student();
    	   
    	   student.setRno(101);
    	   student.setName("pradeep");
    	   student.setPer(98.2);
    	   
    	   transaction.commit();
    	   
    	   System.out.println("Record inserted Successfully.!!!");
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
