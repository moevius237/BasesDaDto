package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
*Patrones de diseño
* Singleton (antipatron)
 */
public class DatabaseConnection {
    private static Connection conn;

    static {
        String user = "root";
        String password = "admin";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:33060/mydb",user,password);
        } catch (SQLException e) {
            System.out.println("Ha habido un error en la conexion");
        }
    }

    private DatabaseConnection() {
    }
    public static Connection getConn(){
        return conn;
    }

    public static void main(String[] args) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
