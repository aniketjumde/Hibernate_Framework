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
 * Inheritance Mapping 
 * 
 *  There are Three Type
 *  
 *  1)Table per class Mapping
 *  2)Table Per Sub-class Mapping
 *  3)Table per Conquerete Mapping
 * 
 * 
 *1) TABLE PER CLASS MAPPING 
 *
 *In table class per maaping Emplyee(Super class) inherit in Executive(base class)
 *
 *	Employee(id,name)
 *		|							
 *		|
 *		|
 *  Executive(role)
 *  
 *  +-----+---------------+
| eid | ename | erole     |
+-----+-------+-----------+
| 101 | AAA   | NULL      |
| 102 | BBB   | Developer |
+-----+---------------+---

Hya table varun apan kasa Segrigate karu ki ha data Emplyee cha ahe Or Executive cha ahe
ha Problem Solve karnaya Sathi " @Discremater " Vaprun apan Segrigate karu Shakto


Discremanator ha ek Colum Madhe Table Che name Deta ahe

+-----+---------------+-------+-----------+
| eid | discremenater | ename | erole     |
+-----+---------------+-------+-----------+
| 101 | EMPLOYEE      | AAA   | NULL      |
| 102 | EXECUTIVE     | BBB   | Developer |
+-----+---------------+-------+-----------+

 
 
 1. Concept Recap

In Table Per Class Mapping (Single Table Strategy):

All parent and child class data is stored in one single table.

The discriminator column helps Hibernate identify which row belongs to which class.

This approach uses annotations like:

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn

@DiscriminatorValue


 
*/