package com.lab.apis.models;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private Double precio;

    public Libro(int id, String titulo, String autor, String genero, Double precio){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.precio = precio;
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getGenero(){
        return genero;
    }

    public Double getPrecio(){
        return precio;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }
}
