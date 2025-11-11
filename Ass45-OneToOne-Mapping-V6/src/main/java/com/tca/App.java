package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Car;
import com.tca.entities.Engine;

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
        	//Insert The Record
        	Engine e=new Engine();
        	e.setEid(1234);
        	e.setEsize("1200cc");
        	e.setEtype("petrol");
        	
        	session.persist(e);
        	
        	Car c=new Car();
        	c.setCno("MH14AB1234");
        	c.setCname("swift");
        	c.setEngine(e);
        	session.persist(c);
        	*/
        	
        	
        	/*
        	
        	//Unique Constraints Violents error
        	
        	Car c=new Car();
        	c.setCno("MH149002");
        	c.setCname("Fortuner");
        	Engine e=session.get(Engine.class,1234);
        	c.setEngine(e);
        	
        	session.persist(c);
        	*/
        	
        	/*
        	//Fetch the Data on car 
        	
        	Car c=session.get(Car.class,"MH14AB1234");
        	
        	System.out.println("Car Information :");
        	System.out.println("Car No :"+c.getCno());
        	System.out.println("Car Name :"+c.getCname());
        	System.out.println("Engine Information :");
        	System.out.println("Engine id :"+c.getEngine().getEid());
        	System.out.println("Engine type :"+c.getEngine().getEtype());
        	System.out.println("Engine Size :"+c.getEngine().getEsize());
        	*/
        	
        
        	//Fetch the Data On Engine
        	
        	Engine e=session.get(Engine.class,1234);
        	System.out.println("Car Information :");
        	System.out.println("Car No :"+e.getCar().getCno());
        	System.out.println("Car Name :"+e.getCar().getCname());
        	System.out.println("Engine Information :");
        	System.out.println("Engine id :"+e.getEid());
        	System.out.println("Engine type :"+e.getEtype());
        	System.out.println("Engine Size :"+e.getEsize());
        
        	
        	
        	transaction.commit();
        	System.out.print("Work is Done .!!!");
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
 * 
 * 1) Unidirectional Mapping

		One entity knows the relationship, the other does NOT.

		Example:

		A → B
		A has reference to B
		But B does NOT have reference to A.
 * 
 * 		Exmple:
 * 		Car Konws the list of Engine
 * 		But Engine doesn't knows the car information
 * 
 * 		
 * 
 * 	) Bidirectional Mapping

		Both entities know about each other.
		
		Example:
		
		A ↔ B
		A has reference to B → and B also has reference to A.
 * 
 * 		exapmle:
 * 	
 * 		
 * 		Exmple:
 * 		Car Konws the list of Engine
 * 		Engine Also knows the car information
 * 
 * 
 * 
 * 		Above Exapmle is Bidirectiona Because fetch record on the basic of Car and Engine all  record get
 */
