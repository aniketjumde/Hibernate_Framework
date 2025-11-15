package com.tca;

/* Singleton DesignPattern
 * It restrict the Class create only one Object
 * 
 */

class A
{
	private static A ob=null;
	
	private A()
	{
		
	}
	
	public static A getInstance()
	{
		if(ob==null)
		{
			ob=new A();
		}
		
		return ob;
	}
}


public class Demo 
{
	public static void main(String args[])
	{
		A ob1=A.getInstance();
		A ob2=A.getInstance();
		
		//A ob=new A();   we can not create object using new Beacuse Constructor is private 
		
		System.out.println(ob1);
		System.out.println(ob2);
		//Both object get Same reference Means Object is created Only once
		
	}
	
}
