package com.tca;

import com.tca.entity.Student;

public class Demo 
{

	public static void main(String args[])
	{
		Student ob=new Student();
		ob.setRno(101);
		ob.setName("Aniket");
		ob.setPer(98.28);
		
		System.out.println("Roll No : "+ob.getRno());
		System.out.println("Name    : "+ob.getName());
		System.out.println("Per     : "+ob.getPer());
		
	}
}
