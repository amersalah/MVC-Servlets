/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.dao;

import com.amer.entity.User;
import com.amer.session.MySessionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Amer Salah
 */
public class UserDao {
    
    MySessionFactory  factory ;
    Session session;
    
    public UserDao()
    {
       factory = MySessionFactory.getInstance();
       session=factory.getSession();
    }
    
     synchronized public void persist(User user) throws SQLException {
        
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();

    }
     
     synchronized  public boolean checkUser(String username , String password)
     {
         
        session.beginTransaction();
         
        
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", username));
        criteria.add(Restrictions.eq("password", password));
        
        User user = (User) criteria.uniqueResult();
        
        session.getTransaction().commit();
                 
        if(user!=null)
        {
            return true;
        }
        else{
            return false;
        }
     
        
     }
     
     
     synchronized public List<User> getAll()
     {
        
        session.beginTransaction();
        
        List<User> users = new ArrayList<>();
        
        Criteria criteria = session.createCriteria(User.class);
        
        users = criteria.list();
        session.getTransaction().commit();
        return users;
         
     }
     
     
     synchronized public List<User> getByName(String name)
     {
         
        session.beginTransaction();
         
        
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("name", name , MatchMode.ANYWHERE));
        
        List<User> users = new ArrayList<>();
        users = criteria.list();
        
        session.getTransaction().commit();
        
        return users;
        
     }
     
     
    
}
