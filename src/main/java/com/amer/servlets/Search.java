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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(value = "/searchServlet")
public class Search extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String searchText = req.getParameter("searchText");
        List<User> users = new ArrayList<>();

        UserDao userDao = new UserDao();
        users = userDao.getByName(searchText);

        req.setAttribute("users", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("newSearch.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.html");
        } else {

            String loggedin = (String) session.getAttribute("loggedIn");
            if (loggedin == null || !loggedin.equals("true")) {
                resp.sendRedirect("login.html");
            } else {

                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                List<User> users = new ArrayList<>();

                UserDao userDao = new UserDao();
                users = userDao.getAll();

                req.setAttribute("users", users);

                RequestDispatcher rd = req.getRequestDispatcher("newSearch.jsp");
                rd.forward(req, resp);
            }
        }
    }
}
