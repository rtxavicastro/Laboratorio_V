package com.lab.apis.models;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private Double salario;
    private String departamento;

    public Empleado(int id, String nombre, String puesto, Double salario, String departamento){
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.departamento = departamento;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getPuesto(){
        return puesto;
    }

    public Double getSalario(){
        return salario;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPuesto(String puesto){
        this.puesto = puesto;
    }

    public void setSalario(Double salario){
        this.salario = salario;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
}
