package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class AddStudent {

	public static void main(String[] args) 
	{
		
		Connection con = null;
		PreparedStatement ps=null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL    = "jdbc:mysql://localhost:3306/hfb03";
		final String DB_USER   = "root";
		final String DB_PWD    = "root";
		
		
		try
		{
			// 1. Load & Register Driver
			
			Class.forName(DB_DRIVER);
						
			// 2. Form Connection
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			// 3. Prepared SQL
			
			System.out.print("Enter the Roll Number :");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Name :");
			String name = br.readLine();
			
			System.out.print("Enter the Percentage :");
			double per = Double.parseDouble(br.readLine());
			
			ps = con.prepareStatement("INSERT INTO student VALUES(?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setDouble(3,per);
			
			// 4. Fire SQL
			
			int val = ps.executeUpdate();  // val=0
			
			// 5. Process Result
			
			if(val==1)
			{
				System.out.println("Record is Insereted Succesfully");
			}
			else
			{
				System.out.println("Failed to Save Record !!");
			}
		
		}
		catch(Exception e)
		{
			System.out.println("***********Insertion Faild******************");
			e.printStackTrace();
		}
		finally
		{
			// 6. close the connection.
			
			try 
			{
				System.out.println("***********Resources Closed******************");
				
				br.close();
				con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

	}

}
