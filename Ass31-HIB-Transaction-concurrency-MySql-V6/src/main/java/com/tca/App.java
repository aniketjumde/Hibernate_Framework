package com.tca;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Account;


public class App 
{
    public static void main(String[] args) {
    	Configuration configuration=null;
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;
        
        Integer senderAccNo   = 101;
        Integer receiverAccNo = 102;
        Float   amount        = 8000.0f;
        
        try
        {
        	configuration=new Configuration();
        	configuration.configure();
        	
        	sessionFactory=configuration.buildSessionFactory();
        	session=sessionFactory.openSession();
        	
        	// Validating Senders and Receivers accounts

        	Account senderOb=session.get(Account.class,senderAccNo,LockMode.PESSIMISTIC_WRITE);
        	
        	if(senderOb==null)
        	{
        		System.out.println("Invalid Sender's Account Number :" + senderAccNo);
    			return;
        	}
        	
        	if(senderOb.getBalance()-amount<500)
        	{
        		System.out.println("Insufficient Balance !!!");
    			return;
        	}
        	
        	Account receiverOb=session.get(Account.class,receiverAccNo,LockMode.PESSIMISTIC_WRITE);
        	
        	if(receiverOb==null)
        	{
        		System.out.println("Invalid Receiver's Account Number : "+receiverAccNo);
        		return;
        	}
        	
        	transaction=session.beginTransaction();
        	
        	System.out.println("Press Any key... ");
    		System.in.read();
        	
        	//Debit
        	
        	senderOb.setBalance(senderOb.getBalance()-amount);
        	
        	//Credit
        	receiverOb.setBalance(receiverOb.getBalance()+amount);
        	
        	transaction.commit();  
    		
    		System.out.println("Amount is Transfered Succesfully !!!");
    		
    		System.out.println("Press Any key to exit... ");
    		System.in.read();
    	}
    	catch(Exception e)
    	{
    		transaction.rollback();
    		e.printStackTrace();
    		System.out.println("Failed to Transfer Amount Succesfully !!!");
    	}
    	finally
    	{
    		session.close();
    		sessionFactory.close();
    	}
    }
}
