/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Amer Salah
 */
public class MySessionFactory {

    //private Constructor
    private MySessionFactory() {
    }

    static SessionFactory factory = null;
    static Session session = null;

    static MySessionFactory sessionFactory = null;
    
    public static MySessionFactory getInstance() {
        if (sessionFactory == null) {
            sessionFactory = new MySessionFactory();
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }

    public Session getSession() {

        factory= new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        return session;
    }

}
