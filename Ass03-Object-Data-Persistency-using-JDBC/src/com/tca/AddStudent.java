package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.tca.entity.Student;
import com.tca.util.StudentUtill;

public class AddStudent {

	public static void main(String[] args) 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try
		{
			
			System.out.print("Enter the Roll Number :");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Name :");
			String name = br.readLine();
			
			System.out.print("Enter the Percentage :");
			double per = Double.parseDouble(br.readLine());
			
			Student ob=new Student();
			ob.setRno(rno);
			ob.setName(name);
			ob.setPer(rno);
			
			if( StudentUtill.save(ob) )
			{
				System.out.println("Record is Saved Succesfully for Roll number :" + rno);
			}
			else
			{
				System.out.println("Failed to Save Record for Roll Number : " + rno);
			}
		}
		
		catch(ClassNotFoundException ce)
		{
			System.out.println("Failed to load the Driver.!!");
			//ce.printStacTrace();
		}
		
		catch(SQLException se)
		{
			System.out.println("Failed to Save Record" );
			//se.printStackTrace();
		}
		
		catch(IOException ie)
		{
			System.out.println("Failed to detect Input Detect input Device !!!");
			//ie.printStackTrace();
		}
		
		catch(NumberFormatException ne)
		{
			System.out.println("Invalid Input.!!");
			//ne.printStackTrace();
		}
		
		finally
		{

			try {
				System.out.println("****Resources Closed*******");
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
