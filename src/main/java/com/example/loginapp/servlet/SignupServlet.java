/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.loginapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.loginapp.entity.User;
import com.example.loginapp.service.UserService;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mtalam
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/register"})
public class SignupServlet extends HttpServlet{
    
    public void processRequest(HttpServletRequest req, HttpServletResponse resp){
        PrintWriter out = null;
        try {
            //Extrract user parameters
            //create user object
            //call userservice
            resp.setContentType("text/html");
            out = resp.getWriter();
            String userName = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = new User(userName,email,password);
            System.out.println(user);
            new UserService().save(user);
            
            out.print("data is inserted");
            
        } catch (IOException ex) {
            Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
        
        
        
        
        
    } 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    
}
