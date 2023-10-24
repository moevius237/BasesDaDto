package com.company.mysql;

import com.company.model.Employes;
import com.company.model.Project;
import com.company.util.DatabaseConnection;

import java.sql.*;

public class EmploymentsAccesDatabase {
    private static Connection conn = DatabaseConnection.getConn();
    //insert , se pasa un empleado , nombre de proyecto, nombre de departamento
    //y city departamento , devuelve el ide del empleado insertado
    //1, select
    //2, inser
    public static int insert(Employes emp, String project , String dptoname , String dptocity) throws SQLException{
        String insert = "INSERT INTO employes(name,salary,project_id "+"department_name ,department_city) VALUES(?,?,?,?,?)";
        String select = "SELECT  id FROM proyect WHERE name=?";
        try(PreparedStatement pselect = conn.prepareStatement(select);
            PreparedStatement pInsert = conn.prepareStatement(insert , Statement.RETURN_GENERATED_KEYS)){
            pselect.setString(1, project);

            ResultSet rSel = pselect.executeQuery();

            int idp = -1;
            if (rSel.next()){
                idp = rSel.getInt(1);
                pInsert.setString(1,emp.getName());
                pInsert.setInt(2,emp.getSalary());
                pInsert.setInt(3,idp);
                pInsert.setString(4,dptoname);
                pInsert.setString(5,dptocity);

                int row = pInsert.executeUpdate();
                ResultSet rs = pInsert.getGeneratedKeys();
                if (row >= 0 && rs.next() ){
                    return rs.getInt(1);
                }


            }
        }
        return -1;
    }

}
