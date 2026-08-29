package com.lab.apis.models;

public class Vehiculo {

    private int id;
    private String marca;
    private String modelo;
    private int anio;
    private Double precio;

    public Vehiculo(int id, String marca, String modelo, int anio, Double precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public int getId() { 
        return id; 
    }
    public String getMarca() { 
        return marca; 
    }
    public String getModelo() { 
        return modelo; 
    }
    public int getAnio() { 
        return anio; 
    }
    public Double getPrecio() { 
        return precio; 
    }

    public void setId(int id) { 
        this.id = id; 
    }
    public void setMarca(String marca) { 
        this.marca = marca; 
    }
    public void setModelo(String modelo) { 
        this.modelo = modelo; 
    }
    public void setAnio(int anio) { 
        this.anio = anio; 
    }
    public void setPrecio(Double precio) { 
        this.precio = precio; 
    }
}