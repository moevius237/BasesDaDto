package com.company.app;

import com.company.model.Department;
import com.company.model.Employes;
import com.company.model.Login;
import com.company.model.Project;
import com.company.mysql.DepartmentAccesDatabase;
import com.company.mysql.EmploymentsAccesDatabase;
import com.company.mysql.LoginHandleDB;
import com.company.mysql.ProjectAccesDb;
import com.company.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

/*

Statement y preparedStatement


 */

public class Main {

    public static void main(String[] args) {
        //JDBC
        try{
        LoginHandleDB loginHandleDB = new LoginHandleDB();
        loginHandleDB .insertLogin(new Login("admin","root", LocalDateTime.now()));
        for (Login l : loginHandleDB.getLogins()) {
            System.out.println(l);
        }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            DepartmentAccesDatabase.insert(new Department("iT","Elche","129302312"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            ProjectAccesDb.insert(new Project("proy",19));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            EmploymentsAccesDatabase.insert(new Employes("Pablo",100), "java","nano nigga","lil nigga");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(EmploymentsAccesDatabase.GetEmployeeByDepartment("IT"));
       /*
        EmploymentsAccesDatabase.insert(new Employes("panchita",20),
                new Project("Locura",2.3)
                new Department("Ir","Elche","23123231",));

        */
    }

    }
