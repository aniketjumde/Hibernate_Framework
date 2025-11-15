package com.tca.Factory;

import com.tca.pojo.Car;
import com.tca.pojo.Mahindra;

public class CarFactory 
{
	private static Car ob=null;
	
	private CarFactory()
	{

	}
	
	public static Car getCar()
	{
		if(ob==null)
		{
			ob=new Mahindra();
		}
		
		return ob;
		
	}
}
