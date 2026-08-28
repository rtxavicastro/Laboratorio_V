package com.lab.apis.models;

public class Producto {
    private int id;
    private String nombre;
    private Double precio;
    private String categoria;

    public Producto(int id, String nombre, Double precio, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public Double getPrecio(){
        return precio;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
}
