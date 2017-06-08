/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.loginapp;

import com.example.loginapp.dao.UserDao;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author mtalam
 */
@WebListener
public class ContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");
        new UserDao().createTable();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }
    
}
