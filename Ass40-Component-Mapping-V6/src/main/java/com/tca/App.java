package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Address;
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
    		
    		Address address=new Address();
    		address.setCity("Pune");
    		address.setState("Maharashtra");
    		address.setCountry("India");
    		
    		Student s1=new Student();
    		s1.setId(101);
    		s1.setName("Aniket");
    		s1.setPer(89.23);
    		s1.setAddress(address);
    		
    		session.persist(s1);
    		
    		Student s2=new Student();
    		s2.setId(102);
    		s2.setName("Pradeep");
    		s2.setPer(98.21);
    		s2.setAddress(address);
    		
    		session.persist(s2);
    		
    		Student s3=new Student();
    		s3.setId(103);
    		s3.setName("Kaushal");
    		s3.setPer(72.2);
    		s3.setAddress(address);
    		
    		session.persist(s3);
    		
    		transaction.commit();
    		
    		System.out.println("Work is Done .!!!");
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


/*
 * In a Java Componet mapping is used When The Some Coloum  Value is Repeted Many time like
 * +-----+-------+------+---------+---------+-------------+
| id  | per   | city | country | name    | state       |
+-----+-------+------+---------+---------+-------------+
| 101 | 89.23 | Pune | India   | Aniket  | Maharashtra |
| 102 | 98.21 | Pune | India   | Pradeep | Maharashtra |
| 103 |  72.2 | Pune | India   | Kaushal | Maharashtra |
+-----+-------+------+---------+---------+-------------+

This Table city,state,country are repeated When in Caching Memory 
In Student Object  Stored The Reference Of This Value 
like

Student(101,Aniket,89,refernce)
Student(102,Pradeep,98,refernce)
Student(103,Kaushal,72,reference)

Address(Pune,Maharashtra,India)


In above Student have 3 Object But Address have Only one object and Refrence is stored in Student Object
That is Optise a memory



Component mapping (also called Embeddable mapping) in Hibernate is used when an entity class contains a group of fields that 
logically belong together, and these fields are repeated for multiple records.
Instead of duplicating those values in memory, Hibernate allows you to store them as a separate object and embed a reference inside the main entity.


*/