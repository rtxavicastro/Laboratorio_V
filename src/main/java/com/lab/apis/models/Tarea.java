package com.lab.apis.models;

public class Tarea {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private Boolean completada;

    public Tarea(Integer id, String titulo, String descripcion, String prioridad, Boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    public Integer getId() { 
        return id; 
    }
    public String getTitulo() { 
        return titulo; 
    }
    public String getDescripcion() { 
        return descripcion; 
    }
    public String getPrioridad() { 
        return prioridad; 
    }
    public Boolean getCompletada() { 
        return completada; 
    }

    public void setId(Integer id) { 
        this.id = id; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }
    public void setPrioridad(String prioridad) { 
        this.prioridad = prioridad; 
    }
    public void setCompletada(Boolean completada) { 
        this.completada = completada; 
    }
}
