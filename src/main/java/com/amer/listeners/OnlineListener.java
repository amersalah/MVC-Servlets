/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author AmerSalah
 */
public class OnlineListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("online", new Integer(0));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
