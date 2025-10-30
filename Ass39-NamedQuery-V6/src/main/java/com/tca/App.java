package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

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
        	List<Student> L=session.createNamedQuery("GET_ALL_INFO",Student.class).list();
        	
        	for(Student S:L)
        	{
        		System.out.println(S.getRno()+" "+S.getName()+" "+S.getPer()+" "+S.getCity());
        	}
        	*/
        	
        	/*
        	Query<Student> query=session.createNamedQuery("GET_CITYWISE",Student.class);
        	query.setParameter("fcity","POONA");
        	
        	List<Student> L=query.list();
        	for(Student S:L)
        	{
        		System.out.println(S.getRno()+" "+S.getName()+" "+S.getPer()+" "+S.getCity());
        	}
        	
        	*/
        	
       /*
        	MutationQuery query=session.createNamedMutationQuery("MODIFY_STUDENT_INFO");
        	query.setParameter("newcity","PUNE");
        	query.setParameter("oldcity","POONA");
        	
        	int rowCount=query.executeUpdate();
        	System.out.println("No.of.rows.Modified= "+rowCount);
        */
        	
        	MutationQuery query=session.createNamedMutationQuery("REMOVE_STUDENT");
        	query.setParameter("rollNumber",108);
        	
        	int rowCount=query.executeUpdate();
        	System.out.println("No.of.rows.Deleted= "+rowCount);
        	
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
    }
}
