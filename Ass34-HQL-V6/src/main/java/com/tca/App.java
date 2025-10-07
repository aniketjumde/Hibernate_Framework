package com.tca;

import java.util.List;

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
        	// Test-Code 1 : Display all records  with all Column
        	
        	Query<Student> query=session.createQuery("From Student",Student.class); //SELECT * FROM Student
        	
        	List<Student> list=query.list(); //Query is Fired
        	
        	for(Student s:list)
        	{
        		System.out.println("Roll No    : "+s.getRno());
        		System.out.println("Name   	   : "+s.getName());
        		System.out.println("Percentage : "+s.getPer());
        		System.out.println("City       : "+s.getCity());
        		System.out.println("---------------------------------------");
        	}
        	*/
        	
        	/*
        	// Test-Code 2 : Display all records  with SPECIFIC COLUMN
        	
        	Query<Object[]> query=session.createQuery("SELECT name,city FROM Student",Object[].class);
        	
        	List<Object[]> list=query.getResultList();
        	
        	for(Object[] ob:list)
        	{
        		for(Object data:ob)
        		{
        			System.out.print(data+" ");
        		}
        		System.out.println();
        	}
        	
        	*/
        	
        	
        	
        	/*
        	// Test-Code 3 : Display all records  with Doesn't exist Column
        	
        	Query<Object[]> query=session.createQuery("SELECT name,city,per+5 As BonusMarks FROM Student",Object[].class);
        	
        	List<Object[]> list=query.getResultList();
        	
        	for(Object[] ob:list)
        	{
        		for(Object data:ob)
        		{
        			System.out.print(data+" ");
        		}
        		System.out.println();
        	}
        	
        	*/
        	
        	/*
        	// Test code 4 : Aggregate Function : COUNT(*),MAX(),MIN(),SUM(),AVG()
        	
        	Query<Long> query=session.createQuery("SELECT COUNT(*) FROM Student",Long.class);
        	
        	long noOfRecord=query.getSingleResult();
        	
        	System.out.println("No of Records :"+noOfRecord);
        	
        	*/
        	
        	
        	
        	/*
        	//Test code 5: MAX per from Studentd
        	
        	Query<Double> query=session.createQuery("SELECT MAX(per) FROM Student",Double.class);
        	
        	Double maxPer=query.getSingleResult();
        	
        	System.out.println("Max Per :"+maxPer);
        	*/
        	
        	
        	/*
        	//Test Code 6: Group By
        	
        	Query<Object[]> query=session.createQuery("SELECT city,count(*) FROM Student GROUP BY city",Object[].class);
        	
        	List<Object[]> list=query.getResultList();
        	
        	for(Object[] ob:list)
        	{
        		for(Object data:ob)
        		{
        			System.out.print(data+" ");
        		}
        		System.out.println();
        	}
        	*/
        	
        	
        	/*
        	//Test code 7 : Having
        	
        	Query<Object[]> query=session.createQuery("SELECT city,count(*) FROM Student GROUP BY city HAVING count(*)>=2",Object[].class);
        	List<Object[]> list=query.getResultList();
        	
        	for(Object[] ob: list)
        	{
        		System.out.println("City : "+ob[0]);
        		System.out.println("No of city : "+ob[1]);
        		System.out.println("------------------");
        	}
        	*/
        	
        	
        	/*
        	//Test code 8: Like Function
        	
        	//Query<String> query=session.createQuery("SELECT city FROM Student WHERE city LIKE 'P%'",String.class);
        	
        	//Query<String> query=session.createQuery("SELECT city FROM Student WHERE city LIKE '%L'",String.class);
        	
        	//Query<String> query=session.createQuery("SELECT city FROM Student WHERE city LIKE '_U%'",String.class);

        	Query<String> query=session.createQuery("SELECT city FROM Student WHERE city LIKE '_A__%'",String.class);

        	List<String> list=query.getResultList();
        	
        	for(String city :list)
        	{
        		
        		System.out.println(city);
        	}
        	*/
        	
        	
        	//Test code 9: Where Clause
        	
        	
        	//Query<Student> query=session.createQuery("FROM Student WHERE  per>=70",Student.class);

        	//Query<Student> query=session.createQuery("FROM Student WHERE  per>=70 AND per<=80",Student.class);

        	//Query<Student> query=session.createQuery("FROM Student WHERE  per BETWEEN 70 AND 80",Student.class);

        	//Query<Student> query=session.createQuery("FROM Student WHERE  city IN ('PUNE','Delhi')",Student.class);

        	
        	Query<Student> query=session.createQuery("FROM Student WHERE  per>=70",Student.class);

        	
        	
        	List<Student> list=query.list(); //Query is Fired
        	
        	for(Student s:list)
        	{
        		System.out.println("Roll No    : "+s.getRno());
        		System.out.println("Name   	   : "+s.getName());
        		System.out.println("Percentage : "+s.getPer());
        		System.out.println("City       : "+s.getCity());
        		System.out.println("---------------------------------------");
        	}
        	
        	
        	
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
