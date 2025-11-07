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
 * Table Per SubClass Mapping
 * 
  It’s a way in Hibernate to store parent and child class
  data in separate tables, but connect them using a common ID.
  
+-----+-------+
| eid | ename |
+-----+-------+
| 101 | AAA   |
| 102 | BBB   |
+-----+-------+

 
 +-----+-----------+
| eid | erole     |
+-----+-----------+
| 102 | Developer |
+-----+-----------+
 
 * 
 */
