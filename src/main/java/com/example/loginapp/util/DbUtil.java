/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.loginapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mtalam
 */
public class DbUtil {
    
    private static Connection conn;
    
    static{
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "sample";
        String user = "root";
        String password = "moonlight";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
    
    public static void close(){
        try{
          conn.close();  
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
