package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.NativeQuery;

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
        	
        	/*
   		 Note 
   		    ---- 
   		     --> In Hibernate 5.x+, the SQLQuery interface is deprecated,  
   		         and the method session.createSQLQuery(...) 
   		     --> It has been replaced with NativeQuery. 
   		*/
        
        	/*
        	NativeQuery<Student> query=session.createNativeQuery("SELECT * FROM student",Student.class);
        	
    		List<Student> L = query.list();
    		
    		for(Student S:L)
    		{
    			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());

    		}
			*/
        	
        	
        	/*
        	NativeQuery<Object[]> query=session.createNativeQuery("SELECT sper,sname,srno FROM student",Object[].class);
        	
        	List<Object[]> L=query.list();
        	
        	for(Object[] ob : L)
    		{
    			for(Object data : ob)
    			{
    				System.out.print(data +" ");
    			}
    			System.out.println();
    			
    		}
        	*/
        	
        	transaction.commit();
        	System.out.println("Work is Done.!!!");
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
