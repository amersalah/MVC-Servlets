/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.servlets;

import com.amer.dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amer Salah
 */
@WebServlet(value = "/servlet1") 
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        
        UserDao userDao = new UserDao();
        boolean flag = userDao.checkUser(username, password);
        
        if(flag)
        {
            HttpSession session = req.getSession(true);
            session.setAttribute("loggedIn", new String("true"));
            resp.sendRedirect("newSearch.jsp");  
            
        }else{
            out.print("Wrong Username or password");
            RequestDispatcher rd=req.getRequestDispatcher("/login.html");  
            rd.include(req, resp);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    
    
}
