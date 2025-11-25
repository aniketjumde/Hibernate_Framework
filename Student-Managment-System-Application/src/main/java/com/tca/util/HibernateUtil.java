package com.tca.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tca.config.HibernateConfig;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory=null;
	
	private HibernateUtil() { }
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			Configuration configuration=new Configuration();
			configuration.configure(HibernateConfig.FILE_NAME);
			sessionFactory=configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	
	public static void closeSessionFactory()
	{
		if(sessionFactory!=null)
		{
			sessionFactory.close();
		}
	}

}
