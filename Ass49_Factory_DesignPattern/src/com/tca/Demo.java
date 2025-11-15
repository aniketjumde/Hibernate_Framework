package com.tca;

import com.tca.Factory.CarFactory;
import com.tca.pojo.Car;

public class Demo 
{
	public static void main(String args[])
	{
		
		Car c=CarFactory.getCar();
		c.running();
		c.stop();
		
		
		
		/*
		 // Lossely Coupled Code

		Car c=new Mahindra();
		c.running();
		c.stop();
		
		
		Car c=new Tata();
		c.running();
		c.stop();
		*/
		/*
		 * // Tightly Coupled Code
		 * this user can drive only mahidra or tata
		
		Mahindra m=new Mahindra();
		m.running();
		m.stop();
		
		Tata t=new Tata();
		t.running();
		t.stop();
		
		*/
	}

}



/*
 * Why used the interface we can run Mahindra and tata class without interface
 * 
 * But interface is give restriction to write run and stop method Compulsary if the implemtentaion is not used
 * that time tata class is write different restriction and create their one and Mahindra also create Same
 * But Interface give the Complusary write this method Another you can add it but run and stop is Compulsary
 * 
 * 
 * 
 * We use an interface to provide a common structure (running(), stop()) and ensure that all car classes 
 * follow the same rules. Without an interface, each class may create its own different methods. When we combine
 *  the interface with a factory, we get loose coupling. The main class (Demo) never depends on Mahindra or Tata 
 *  directly; it only depends on the Car interface. This makes the code flexible and easy to modify or extend.
 * 
 */
