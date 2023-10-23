package com.company.mysql;

/*
Todos los metodos que realizan cosas en la base de datos en la taabla login
 */

import com.company.model.Login;
import com.company.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginHandleDB {
    private static Connection conn = DatabaseConnection.getConn();
    private static List<Login> usarios = null;

    public int insertLogin(Login login) throws SQLException {
        String insert = "INSERT INTO login(username,pass,created_at) VALUES(?,?,?)";
        try(PreparedStatement p = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)){
            p.setString(1, login.getUsername());
            p.setString(2, login.getPassword());
            p.setString(3, String.valueOf(Timestamp.valueOf(login.getCreateAT())));

            p.executeUpdate();
            ResultSet  rs = p.getGeneratedKeys();
            if (rs.next()){
                return rs.getInt(1);
            }


        }

        return -1;
    }

    public List<Login> getLogins() {

        List<Login> logins = new ArrayList<>();
        String select = "SELECT * FROM login";
        try (
                Connection conn = DatabaseConnection.getConn();
                Statement statement = conn.createStatement();
                ResultSet results = statement.executeQuery(select)) {
            while (results.next()) {
                Login login = new Login();
                login.setId(results.getInt("id"));
                login.setUsername(results.getString("username"));
                login.setPassword(results.getString("pass"));
                login.setCreateAT(results.getTimestamp("created_at").toLocalDateTime());
                System.out.println(login);
            }

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return logins;
    }
    public Login getLogin(String name , String password) {

        for (Login us : usarios) {
            if (us.getClass().equals(name) && us.getPassword()
                    .equals(password)) {
                return us;
            }
        }
        return null;
    }
    public int addLogin (Login login){
        usarios.add(login);
        return 0;
    }
    public Login delLoggin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un id para eliminar: ");
        String id = sc.next();
        for (int i = 0; i < usarios.size(); i++) {
            Login log = usarios.get(i);
            if (log.equals(id)){
                usarios.remove(log);
            }
        }
        return null;
    }

}
