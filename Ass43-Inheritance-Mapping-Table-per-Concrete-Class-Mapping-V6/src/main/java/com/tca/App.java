package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Employee;
import com.tca.entity.Executive;
import com.tca.entity.Person;

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
    		
    		
    		Person person=new Person();
    		person.setId(101);
    		person.setName("AAA");
    		
    		session.persist(person);
    		
    		Employee employee=new Employee();
    		employee.setSalary(8000.0);
    		
    		
    		
    		Executive executive=new Executive();
    		executive.setRole("Developer");
    		executive.setBonus(80.0);
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
 * Table per Concurete Mapping
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
