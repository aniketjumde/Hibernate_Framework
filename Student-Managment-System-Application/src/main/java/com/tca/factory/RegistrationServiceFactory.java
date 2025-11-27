package com.tca.factory;

import com.tca.service.RegistrationService;
import com.tca.service.RegistrationServiceImpl;

public class RegistrationServiceFactory 
{
	private static RegistrationService registrationService=null;

	private RegistrationServiceFactory() { }
	
	public static RegistrationService getRegestrationServiceInstance()
	{
		if(registrationService==null)
		{
			registrationService=new RegistrationServiceImpl();
		}
		
		return registrationService;
	}
}
