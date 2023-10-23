package com.company.model;

public class Employes {
    private int id;
    private String name;
    private int salary;
    private String department_name;
    private String department_city;
    private int proyect_id;

    public Employes(String name, int salary, String department_name, String department_city, int proyect_id) {
        this.name = name;
        this.salary = salary;
        this.department_name = department_name;
        this.department_city = department_city;
        this.proyect_id = proyect_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_city() {
        return department_city;
    }

    public void setDepartment_city(String department_city) {
        this.department_city = department_city;
    }

    public int getProyect_id() {
        return proyect_id;
    }

    public void setProyect_id(int proyect_id) {
        this.proyect_id = proyect_id;
    }

    @Override
    public String toString() {
        return "Employes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department_name='" + department_name + '\'' +
                ", department_city='" + department_city + '\'' +
                ", proyect_id=" + proyect_id +
                '}';
    }
}
