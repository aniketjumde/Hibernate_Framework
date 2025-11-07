package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Employee;
import com.tca.entity.Executive;

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
    		
    		Employee employee=new Employee();
    		employee.setId(101);
    		employee.setName("AAA");
    		
    		session.persist(employee);
    		
    		Executive executive=new Executive();
    		executive.setId(102);
    		executive.setName("BBB");
    		executive.setRole("Developer");
    		
    		session.persist(executive);
    		
    		transaction.commit();
    		System.out.println("Work is Done !!!");
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


/*
 * Inheritance Mapping 
 * 
 *  There are Three Type
 *  
 *  1)Table per class Mapping
 *  2)Table Per Sub-class Mapping
 *  3)Table per Conquerete Mapping
 * 
 * 
*/