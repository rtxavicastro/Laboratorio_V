package com.lab.apis.models;

public class Cliente {

    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    public Cliente(Integer id, String nombre, String apellido, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Integer getId() { 
        return id; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public String getApellido() { 
        return apellido;
    }
    public String getCorreo() { 
        return correo; 
    }
    public String getTelefono() { 
        return telefono; 
    }

    public void setId(Integer id) { 
        this.id = id; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void setApellido(String apellido) { 
        this.apellido = apellido; 
    }
    public void setCorreo(String correo) { 
        this.correo = correo; 
    }
    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    }
}