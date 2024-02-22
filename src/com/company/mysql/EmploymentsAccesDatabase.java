package com.company.mysql;

import com.company.model.Department;
import com.company.model.Employes;
import com.company.model.Project;
import com.company.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public static List<Employes> GetEmployeeByDepartment(String departname) {
        String call = "{call sp_GetEmployeeByDepartment(?)}";
        List<Employes> employes = new ArrayList<>();
        try (CallableStatement stmt = conn.prepareCall(call)){
            stmt.setString(2, departname);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                Employes e = new Employes(rs.getString("name"), (rs.getInt("salary")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static int insertEmployeeComplete(Employes employes, Project project , Department dpto) throws SQLException {
        conn.setAutoCommit(false);
        String empIn = "INSERT INTO employes(name, salary, department_name,departmetn_city,proyect_id)VALUES(?,?,?,?,?)";
        String proIn = "INSERT INTO proyect(name, price)VALUES(?,?)";
        String depIn = "INSERT INTO department(name,city)VALUES(?,?)";

        try {
            int idp = ProjectAccesDb.insert(project);
            if (idp > 0) {
                if (DepartmentAccesDatabase.insert(dpto) != 1) {
                    employes.setId(idp);
                    employes.setName(dpto.getName());
                    employes.setName(dpto.getCity());
                    // int id = insert(employes);
                    //  if (id != -1){
                    //      conn.commit();
                    //      return id;
                    //       }
                }
            }
        } catch (SQLException e) {
            conn.rollback();
            throw new SQLException();
        }
        return 0;
    }
}
