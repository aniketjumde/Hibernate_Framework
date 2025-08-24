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
    		configuration=new Configuration();
    		
    		//Database Property
    		configuration.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
    		configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hfb03");
    		configuration.setProperty("hibernate.connection.username","root");
    		configuration.setProperty("hibernate.connection.password","root");
    		
    		//Hibernate Property
    		configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
    		configuration.setProperty("hibernate.show_sql","true");
    		configuration.setProperty("hibernate.format_sql","true");
    		configuration.setProperty("hibernate.hbm2ddl.auto","create");
    		
    		//mapping file
    		configuration.addResource("Student.hbm.xml");
    		
    		sessionFactory=configuration.buildSessionFactory();
    		session=sessionFactory.openSession();
    		transaction=session.beginTransaction();
    		
    		Student student=new Student();
    		student.setRno(101);
    		student.setName("AJ");
    		student.setPer(98.23);
    		
    		session.save(student);
    		
    		transaction.commit();
    		
    		System.out.println("Record is inserted Succesfully.!!");
    	}
    	catch(Exception e)
    	{
    		transaction.commit();
    		e.printStackTrace();
    	}
    	
    	finally
    	{
    		session.close();
    		sessionFactory.close();
    	}
    }
      
}
