package com.company.mysql;

import com.company.util.DatabaseConnection;

import java.sql.Connection;

public class EmploymentsAccesDatabase {
    private static Connection conn = DatabaseConnection.getConn();
    //insert , se pasa un empleado , nombre de proyecto, nombre de departamento
    //y city departamento , devuelve el ide del empleado insertado
    //1, select
    //2, insert
}
