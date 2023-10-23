package com.company.mysql;

import com.company.util.DatabaseConnection;

import java.sql.Connection;

public class ProjectAccesDb {
    private static Connection conn = DatabaseConnection.getConn();
    //todo metodo insert se le pasa un proyecto , se le pasa en la de datos y devuelve el id(PreparedStatement)

}
