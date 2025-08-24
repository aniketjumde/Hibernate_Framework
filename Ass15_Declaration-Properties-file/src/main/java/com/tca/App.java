package com.tca;

import java.io.FileInputStream;
import java.util.Properties;

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
        	
        	FileInputStream fis=new FileInputStream("src/main/resources/tca.properties");
        	
        	Properties properties=new Properties();
        	properties.load(fis);
        	
        	configuration.setProperties(properties);
        	
        	//Mapping- file
        	configuration.addResource("Student.hbm.xml");
        	
        	
        	sessionFactory=configuration.buildSessionFactory();
        	session=sessionFactory.openSession();
        	transaction=session.beginTransaction();
        	
        	
        	Student student=new Student();
        	student.setRno(101);
        	student.setName("Aniket");
        	student.setPer(89.23);
        	
        	session.save(student);
        	
        	transaction.commit();
        	
        	System.out.println("Record is Inserted Successfully.!!!");
        	
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
