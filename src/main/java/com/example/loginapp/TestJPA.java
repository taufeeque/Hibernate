/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.loginapp;

import com.example.loginapp.jpa.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mtalam
 */
public class TestJPA {

    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("default");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setEname("Gopal");
        employee.setSalary(40000);
        employee.setDeg("Technical Manager");

        entitymanager.persist(employee);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }

}
