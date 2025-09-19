package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Student;
import com.tca.entity.StudentCompositeKey;

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
        	configuration = new Configuration();
    		configuration.configure();
    		sessionFactory=configuration.buildSessionFactory();
    		session=sessionFactory.openSession();
    		transaction=session.beginTransaction();
    		
    		/*
    		 * Test Code of Insert The Data
    		 */
    		
    		/*
    		StudentCompositeKey studentCompositeKey=new StudentCompositeKey();
    		studentCompositeKey.setFname("Sachin");
    		studentCompositeKey.setLname("Tendular");
    		
    		
    		Student student=new Student();
    		student.setStudentCompositeKey(studentCompositeKey);
    		student.setCity("Mumbai");
    		
    		session.persist(student);
    		transaction.commit();
    		System.out.println("Record is saved Successfully !!!");
    		*/
    		
    		/*
    		 * Test Code for Fetch the Data
    		 */
    		StudentCompositeKey key=new StudentCompositeKey();
    		key.setFname("Sachin");
    		key.setLname("Tendular");
    		
    		Student student=(Student) session.get(Student.class, key);
    		
    		if(student==null)
    		{
    			System.out.println("Record is Not Found");
    		}
    		else
    		{
    			System.out.println("Name: " + key.getFname() + " " + key.getLname());
    		    System.out.println("City: " + student.getCity());
    		}
    		
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
