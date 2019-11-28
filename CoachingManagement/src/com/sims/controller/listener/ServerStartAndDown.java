package com.sims.controller.listener;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sims.utils.Cache;


@WebListener
public class ServerStartAndDown implements ServletContextListener {

    
    public ServerStartAndDown() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try {
			Cache.cacheGender();
			Cache.cacheCourse();
			Cache.cacheStatus();
			Cache.cacheReferralBy();
			Cache.cachePaymentType();
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
