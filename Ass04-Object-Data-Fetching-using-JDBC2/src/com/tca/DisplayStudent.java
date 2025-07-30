package com.tca;


import java.sql.SQLException;
import java.util.List;

import com.tca.entity.Student;
import com.tca.util.StudentUtill;

public class DisplayStudent {

	public static void main(String[] args) 
	{
		/*	
		List<Student>  L = new ArrayList<>();
		
		L.add(new Student(101,"AAA", 60));
		L.add(new Student(102,"BBB", 70));
		L.add(new Student(103,"CCC", 80));
		
		System.out.println("Student Information :");
		
		
		for(Student s : L)
		{
			System.out.println("Roll Number : " + s.getRno());
			System.out.println("Name        : " + s.getName());
			System.out.println("Percentage  : " + s.getPer());
			System.out.println("-------------------------------");
		}
		
	*/	
		
		try
		{
			List<Student> L=StudentUtill.fetchAllStudent();
			
			if(L.isEmpty())
			{
				System.out.println("No Record Exists !!!");
			}
			else
			{
				System.out.println("Student Information :");
				
				for(Student s : L)
				{
					System.out.println("Roll Number : " + s.getRno());
					System.out.println("Name        : " + s.getName());
					System.out.println("Percentage  : " + s.getPer());
					System.out.println("-------------------------------");
				}
			}
					
		}
		catch(ClassNotFoundException e)
		{
			//System.out.println("Unable to Load Driver Class !!!");
		}
		catch(SQLException e)
		{
			//System.out.println("Unable to Accces Data/Records :" + e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Unkown Problem : " + e.getMessage());
		}


		System.out.println("Hurreeeey... Done");
	}

}
