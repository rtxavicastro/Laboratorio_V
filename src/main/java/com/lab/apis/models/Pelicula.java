package com.lab.apis.models;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private String genero;
    private int anio;

    public Pelicula(int id, String titulo, String director, String genero, int anio){
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anio = anio;
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDirector(){
        return director;
    }

    public String getGenero(){
        return genero;
    }

    public int getAnio(){
        return anio;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }
}
