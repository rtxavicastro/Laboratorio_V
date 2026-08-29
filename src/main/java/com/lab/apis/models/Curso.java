package com.lab.apis.models;

public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private int creditos;
    private String modalidad;

    public Curso(int id, String nombre, String descripcion, int creditos, String modalidad){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.modalidad = modalidad;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getCreditos(){
        return creditos;
    }

    public String getModalidad(){
        return modalidad;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setCreditos(int creditos){
        this.creditos = creditos;
    }

    public void setModalidad(String modalidad){
        this.modalidad = modalidad;
    }
}
