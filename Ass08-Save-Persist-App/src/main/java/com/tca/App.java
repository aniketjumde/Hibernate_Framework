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
    		configuration.configure();
    		sessionFactory=configuration.buildSessionFactory();
    		session=sessionFactory.openSession();
        	transaction=session.beginTransaction();
        	
        	
        	/*   Difference between Save and Persistance 
        	 * 
        	 * It is  return the Generated ID(rno)
        	 * 
        	 * 
        	 * In Auto Increment Case this is Return the Id value 
        	 * 
        	 * 
        	 * 
        	 * 
        	 * 
        	 * 
        	 * 
        	 * In Persist Only save the Data Not return Id value 
        	 * 
        	 * 
        	
        	Student student=new Student();
        	student.setRno(101);;
        	student.setName("AAA");
        	student.setPer(80.23);
        	
        	int rno=(int)session.save(student);
        	
        	transaction.commit(); //Whatever DB operation performed should be get persisted
        	//permently(Save data in a database permently)
        	
        	System.out.println("Record is saved Succesfully for : "+rno);
        	
        	*/
        	
        	Student student=new Student();
        	student.setRno(101);;
        	student.setName("AAA");
        	student.setPer(80.23);
        	
        	session.persist(student);
        	
        	transaction.commit(); //Whatever DB operation performed should be get persisted
        	//permently(Save data in a database permently)
        	
        	System.out.println("Record is saved Succesfully !!!");
        	
        }
        catch(Exception e)
        {
        	if(transaction != null) {
        		transaction.rollback();
        	}
        	e.printStackTrace();
        }
        
        finally
        {
        	session.close();
        	sessionFactory.close(); //JDBC con Close()
        	
        }
    }
}
