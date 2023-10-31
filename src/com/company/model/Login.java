package com.company.model;

import java.time.LocalDateTime;

/*
SELECT EN MAYUSCULA tablas en minuscula

User_manager

TABLA Login
Interger    varchar(20)     varchar(20)     datetime
id          username        password        create_at
 */
public class Login {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createAT;

    public Login() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateAT() {
        return createAT;
    }


    /*
    Creamos un procedimiento almacenado en mysql
    le llamamos
     */

    public Login(String username, String password, LocalDateTime createAT) {
        this.username = username;
        this.password = password;
        this.createAT = createAT;
    }

    public void setCreateAT(LocalDateTime createAT) {
        this.createAT = createAT;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createAT=" + createAT +
                '}';
    }
}
