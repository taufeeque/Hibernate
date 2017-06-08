/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.loginapp.dao;

import com.example.loginapp.entity.User;
import com.example.loginapp.util.DbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mtalam
 */
public class UserDao {
    
    private Connection conn;
    
    public UserDao(){
        conn = DbUtil.getConnection();
    }
    
    public void createTable() {
         String sql =    "CREATE TABLE IF NOT EXISTS user(\n" +
                        "	user_id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                        "	username VARCHAR(255) NOT NULL,\n" +
                        "	email VARCHAR(255) NOT NULL,\n" +
                        "	password VARCHAR(255) NOT NULL,\n" +
                        "	Primary Key(user_id)\n" +
                        ")";
         
        try{ 
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public User save(User user){
        
        String sql = "INSERT INTO user(username,email,password) VALUES ('"+user.getUserName()+"','"
                + user.getEmail()+"','"+user.getPassword()+"')";
         try{ 
            Statement stmt = conn.createStatement();
            System.out.println(sql);
            int i = stmt.executeUpdate(sql);
            if(i > 0){
                return user;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public boolean authneticate(String email,String password) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user where email='"+email+"' AND password='"+password + "'");
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
