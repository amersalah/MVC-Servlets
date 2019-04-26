/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amer.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Amer Salah
 */
@WebServlet(value = "/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String page = req.getParameter("flag");
        if (page.equals("login")) {

            RequestDispatcher rd = req.getRequestDispatcher("/servlet1");
            rd.forward(req, resp);

        } else if (page.equals("search")) {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/searchServlet");
            dispatcher.forward(req, resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String check = req.getParameter("mod");

        if (check.equals("login")) {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
            dispatcher.forward(req, resp);

        } else if (check.equals("search")) {

            RequestDispatcher rd = req.getRequestDispatcher("/searchServlet");
            rd.forward(req, resp);

        } else if (check.equals("logout")) {

            RequestDispatcher rd = req.getRequestDispatcher("/logoutServlet");
            rd.forward(req, resp);

        }
    }
}
