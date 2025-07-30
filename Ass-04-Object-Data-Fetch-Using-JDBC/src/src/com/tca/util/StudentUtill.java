package com.tca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tca.entity.Student;

public class StudentUtill 
{

	public static boolean save(Student s) throws SQLException, ClassNotFoundException 
	{
		Connection con=null;
		PreparedStatement ps=null;
		

		final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL    = "jdbc:mysql://localhost:3306/hfb03";
		final String DB_USER   = "root";
		final String DB_PWD    = "root";
		
		
		try
		{
			
				Class.forName(DB_DRIVER);
											
				con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
				

				ps = con.prepareStatement("INSERT INTO student VALUES(?,?,?)");
				ps.setInt(1,s.getRno());
				ps.setString(2,s.getName());
				ps.setDouble(3,s.getPer());		
				
				int val=ps.executeUpdate();
				
				if(val==1)
				{
					return true;
				}
		}
		
		finally
		{
			try 
			{
				con.close();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
		
	}

}
