package com.iwinner.hb.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	static SessionFactory sessionFactory=null;
	
	public static SessionFactory sessionFactoryUtil(){
		
		try{
		
		// First Step 1:: BootStartp Class invoke framework
		Configuration conf=new Configuration();
        
		conf.configure("/com/iwinner/hb/config/mycfg-mysql.xml");

        // Setting the config  file
		 //conf.configure("/mycfg-mysql.xml");
		 //conf.configure("/mycfg-mysql.xml");
		 
		 // High level Object
		 sessionFactory =conf.buildSessionFactory();
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return sessionFactory;
	}
	
	public static void closeSession(Session session){
		
		if(session!=null){

			session.close();
			
		}
	}
}
