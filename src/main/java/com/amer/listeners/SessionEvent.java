/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 *
 * @author Amer Salah
 */
public class SessionEvent implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
       
        ServletContext servletContext =se.getSession().getServletContext();
        Integer x = (Integer) servletContext.getAttribute("online");
        //x = new Integer(x.intValue()+1);
        servletContext.setAttribute("online", ++x);
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
            
        ServletContext servletContext =se.getSession().getServletContext();
        Integer x = (Integer) servletContext.getAttribute("online");
        x = new Integer(x.intValue()-1);
        servletContext.setAttribute("online", x);
        
    }

   
}
