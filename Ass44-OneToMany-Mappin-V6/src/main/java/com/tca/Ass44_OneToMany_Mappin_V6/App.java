package com.tca.Ass44_OneToMany_Mappin_V6;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Department;
import com.tca.entity.Employee;

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
    		
    		
    		//Initial have Same dept_id
    		
    		Department department=new Department();
    		department.setDid(111);
    		department.setDname("Cs");
    		
    		Employee e1=new Employee();
    		e1.setEid(101);
    		e1.setEname("AAA");
    		e1.setEsalary(10000.0);
    		e1.setDept(department);
    		
    		Employee e2=new Employee();
    		e2.setEid(103);
    		e2.setEname("CCC");
    		e2.setEsalary(12000.0);
    		e2.setDept(department);
    		
    		
    		List<Employee> emps=Arrays.asList(e1,e2);
    		
    		department.setEmps_list(emps);
    		
    		session.persist(department);
    		
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
    	
    	finally
    	{
    		session.close();
    		sessionFactory.close();
    	}
        
    }
}
