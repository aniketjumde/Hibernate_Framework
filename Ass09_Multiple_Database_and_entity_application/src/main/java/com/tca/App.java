package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.Teacher;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;
        
        Configuration configuration2=null;
        SessionFactory sessionFactory2=null;
        Session session2=null;
        Transaction transaction2=null;
        
        
        
        try
        {
        	configuration=new Configuration();
        	configuration.configure("mysql.cfg.xml");
        	sessionFactory=configuration.buildSessionFactory();
        	session=sessionFactory.openSession();
        	transaction=session.beginTransaction();
        	

        	configuration2=new Configuration();
        	configuration2.configure("postgresql.cfg.xml");
        	sessionFactory2=configuration2.buildSessionFactory();
        	session2=sessionFactory2.openSession();
        	transaction2=session2.beginTransaction();
     	
        	Student student=new Student();
        	student.setRno(103);
        	student.setName("BBB");
        	student.setPer(80.23);
        	
        	session.save(student);
        	session2.save(student);
        	
        	Teacher teacher=new Teacher();
        	
        	teacher.setTno(102);
        	teacher.setName("Kaushal");
        	teacher.setSalary(88801);
        	
        	session.save(teacher);
        	session2.save(teacher);
        	
        	transaction.commit();
        	transaction2.commit();
        	
        	System.out.println("Record is saved Succesfully.!!");
        	
        	
        	
        }
        catch(Exception e)
        {
        	if(transaction != null) {
        		transaction.rollback();
        		
        	}
        	
        	if(transaction2 !=null)
        	{
        		transaction2.rollback();
        	}
        	
        	e.printStackTrace();
        }
        
        finally
        {
        	session.close();
        	session2.close();
        	sessionFactory.close();
        	sessionFactory2.close();
        }
    	
    }
}
