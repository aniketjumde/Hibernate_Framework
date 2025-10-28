package com.tca;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entity.Student;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sf=null;
        Session session=null;
        Transaction txn=null;  // DML Queries - insert , delete, Update
        
        try
        {
        		configuration = new Configuration();
        		configuration.configure();             // hibernate.cfg.xml
        		       		
        		sf = configuration.buildSessionFactory();
        	  	
        		session = sf.openSession();	
        		txn = session.beginTransaction();
        		
        	/*	
        		Filter filter = session.enableFilter("cityfilter");
        		filter.setParameter("tca","PUNE");
        	*/	
        		
        		Filter filter = session.enableFilter("perfilter");
        		filter.setParameter("pqr",70.0);
        		
        		
        		Query<Student> query = session.createQuery("FROM Student", Student.class);		
        		
        		List<Student> L = query.list();
        		
        		for(Student S : L)
        		{
        			System.out.println(S.getRno() +" " + S.getName()+" "+ S.getPer() +" " + S.getCity());
        		}
        		
        		
        		session.disableFilter("perfilter");
        		txn.commit();
        		
        		System.out.println("Work is done !!!");
        		
        }
        catch(Exception e)
        {	
        		txn.rollback();
        		e.printStackTrace();
        }
        finally
        {
        		session.close();
        		sf.close();   // jdbc con.close()
        }
        
        
                   
    }
}