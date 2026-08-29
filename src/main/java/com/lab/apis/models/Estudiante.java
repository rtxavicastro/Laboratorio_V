package com.lab.apis.models;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String carrera;
    private int edad;

    public Estudiante(int id, String nombre, String apellido, String carrera, int edad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.edad = edad;
    }

    public int getId(){
        return id;
    }
    
    public int getEdad(){
        return edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getCarrera(){
        return carrera;
    }

    public int edad(){
        return edad;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }
}
