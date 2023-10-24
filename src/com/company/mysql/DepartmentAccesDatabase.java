package com.company.mysql;

import com.company.model.Department;
import com.company.util.DatabaseConnection;

import java.sql.*;

public class DepartmentAccesDatabase {
    private static Connection conn = DatabaseConnection.getConn();
    //Insert le paso un departamentto no vuelve nada
    public static int insert(Department dpto){
        String insert = "INSERT INTO department(username,pass,created_at) VALUES(?,?,?)";
        try(PreparedStatement p = conn.prepareStatement(insert)){
            p.setString(1, dpto.getName());
            p.setString(2, dpto.getCity());
            p.setString(3, dpto.getPhone());

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
