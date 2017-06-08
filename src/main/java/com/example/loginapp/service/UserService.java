/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.loginapp.service;

import com.example.loginapp.dao.UserDao;
import com.example.loginapp.entity.User;

/**
 *
 * @author mtalam
 */
public class UserService {
    
    private UserDao userDao;
    
    public UserService(){
        userDao = new UserDao();
    }
    
    public User save(User user){
        return userDao.save(user);
    }
    public boolean authUser(String email,String password){
        
        return userDao.authneticate(email, password);
    }
}
