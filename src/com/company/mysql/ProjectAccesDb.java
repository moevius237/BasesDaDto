package com.company.mysql;

import com.company.model.Project;
import com.company.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectAccesDb {
    private static Connection conn = DatabaseConnection.getConn();
    //todo metodo insert se le pasa un proyecto , se le pasa en la de datos y devuelve el id(PreparedStatement)
    public static int insert(Project project){
        String insert = "INSERT INTO proyect(username,pass,created_at) VALUES(?,?,?)";
        try(PreparedStatement p = conn.prepareStatement(insert)){
            p.setString(1, project.getName());
            p.setString(2, String.valueOf(project.getPrice()));

            p.executeUpdate();
            ResultSet rs = p.getGeneratedKeys();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
