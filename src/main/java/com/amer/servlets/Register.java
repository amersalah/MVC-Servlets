/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.servlets;

import com.amer.dao.UserDao;
import com.amer.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amer Salah
 */
@WebServlet(value = "/servlet2") 
public class Register extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        
        User user = new User();
        user.setEmail(email);
        user.setName(username);
        user.setPassword(password);
        user.setPhone(phone);
        
        UserDao userDao = new UserDao();
        
        try {
            userDao.persist(user);
            resp.sendRedirect("newSearch.jsp");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
      
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        
    }
    
    
}
