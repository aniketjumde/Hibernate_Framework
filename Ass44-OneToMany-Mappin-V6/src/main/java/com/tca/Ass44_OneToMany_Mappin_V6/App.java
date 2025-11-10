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
    		
    		/*
    		//Insert two Employee with one Department
    		
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
    		
    		*/
    		
    		
    		/*
    		//Adding Employee With dept_id=null
    		
    		Employee e=new Employee();
    		e.setEid(102);
    		e.setEname("BBB");
    		e.setEsalary(8000.0);
    		
    		session.persist(e);
    		*/
    		
    		
    		//Update The Employee Dept_id AND Add one Dept id
    		
    		/*
    		Department d=new Department();
    		d.setDid(222);
    		d.setDname("art");
    		
    		Employee e=session.get(Employee.class,102);
    		d.setEmps_list(Arrays.asList(e));
    		session.persist(d);
    		*/
    		
    		/*
    		Employee e=session.get(Employee.class,102);
    		Department dep=session.get(Department.class,222);
    		e.setDept(dep);
    		//Setter Is internally call to update
    		*/
    		
    		
    		/* Add Employee Wise Department
    		
    		Department d=new Department();
    		d.setDid(333);
    		d.setDname("IT");
    		
    		Employee e=new Employee();
    		e.setEid(104);
    		e.setEname("DDD");
    		e.setEsalary(5000.0);
    		e.setDept(d);
    		session.persist(e);
    		
    		*/
    		/*
    		
    		//Fetch The Data DepartmentWise
    		
    		Department d=session.get(Department.class,111);
    		System.out.println("Department Information :");
    		System.out.println("Dept_id : "+d.getDid());
    		System.out.println("Department name :"+d.getDname());
    		
    		System.out.println("------------------Employee Information :-------------------- ");
    		List<Employee> L=d.getEmps_list();
    		
    		for(Employee e:L)
    		{
    			System.out.println("Emp id :"+e.getEid());
    			System.out.println("Emp name :"+e.getEname());
    			System.out.println("Emp salary :"+e.getEsalary());
    			
    		}
    		*/
    		
    		/*
    		//Fetch the Data EmployeeWise
    		
    		Employee e=session.get(Employee.class,101);
    		
    		System.out.println("Employee Inforamation : ");
    		System.out.println("Emp id   : "+e.getEid());
    		System.out.println("Emp name : "+e.getEname());
    		System.out.println("Emp salary: "+e.getEsalary());
    		System.out.println("Emp deapartment:"+e.getDept());
    		
    		Department d=e.getDept();
    		System.out.println("----------------Department Information :----------------");
    		System.out.println("Dept id :"+d.getDid());
    		System.out.println("Dept name :"+d.getDname());
    		
    		*/
    		
    		/*
    		// Updating the deptartment id
    		Department d=session.get(Department.class,222);
    		Employee e=session.get(Employee.class,104);
    		e.setDept(d);
    		*/
    		
    		//Deleting the Employee
    		Employee e=session.get(Employee.class,103);
    		session.remove(e);
    		
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
