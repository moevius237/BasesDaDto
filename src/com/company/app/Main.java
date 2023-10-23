package com.company.app;

import com.company.model.Login;
import com.company.mysql.LoginHandleDB;
import com.company.util.DatabaseConnection;
import com.mysql.cj.log.Log;

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
    }

    }
