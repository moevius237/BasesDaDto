package com.company.util;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
*Patrones de diseño
* Singleton (antipatron)
 */
public class DatabaseConnection {
    private static Connection conn;

    static {
        Properties properties = new Properties();

        try {
            properties.load(Files.newBufferedReader(Path.of("datasource.properties")));
            conn = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));
        } catch (SQLException e) {
            System.out.println("Ha habido un error en la conexion");
        } catch (IOException e) {
            e.printStackTrace();
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
