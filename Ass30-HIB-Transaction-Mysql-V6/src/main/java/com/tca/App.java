package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Account;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;
        
        Integer senderAccNo   = 102;
        Integer receiverAccNo = 101;
        Float   amount        = 3000.0f;
        
        try
        {
        	configuration=new Configuration();
        	configuration.configure();
        	
        	sessionFactory=configuration.buildSessionFactory();
        	session=sessionFactory.openSession();
        	
        	// Validating Senders and Receivers accounts
        	
        	Account senderOb=session.get(Account.class,senderAccNo);
        	
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
        	
        	Account receiverOb=session.get(Account.class,receiverAccNo);
        	
        	if(receiverOb==null)
        	{
        		System.out.println("Invalid Receiver's Account Number :"+receiverOb);
        		return;
        	}
        	
        	transaction=session.beginTransaction();
        	
        	//Debit
        	senderOb.setBalance(senderOb.getBalance()-amount);
        	
        	//Credit
        	receiverOb.setBalance(receiverOb.getBalance()+amount);
        	
        	transaction.commit();  
    		
    		System.out.println("Amount is Transfered Succesfully !!!");
    		
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
