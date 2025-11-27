package com.tca.factory;

import com.tca.dao.RegistrationDao;
import com.tca.dao.RegistrationDaoImpl;

public class RegistrationDaoFactory 
{

	private static RegistrationDao registrationDao=null;
	
	private RegistrationDaoFactory() {}
	
	public static RegistrationDao getRegistrationDaoInstance()
	{
		
		if(registrationDao==null)
		{
			registrationDao=new RegistrationDaoImpl();
		}
		
		return registrationDao;
	}
}
