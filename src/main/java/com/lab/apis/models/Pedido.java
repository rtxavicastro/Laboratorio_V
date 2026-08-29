package com.lab.apis.models;

public class Pedido {

    private Integer id;
    private String cliente;
    private String producto;
    private Integer cantidad;
    private Double total;
    private String estado;

    public Pedido(Integer id, String cliente, String producto, Integer cantidad, Double total, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }

    public Integer getId() { 
        return id; 
    }
    public String getCliente() { 
        return cliente; 
    }
    public String getProducto() { 
        return producto; 
    }
    public Integer getCantidad() { 
        return cantidad; 
    }
    public Double getTotal() { 
        return total; 
    }
    public String getEstado() { 
        return estado; 
    }

    public void setId(Integer id) { 
        this.id = id; 
    }
    public void setCliente(String cliente) { 
        this.cliente = cliente; 
    }
    public void setProducto(String producto) { 
        this.producto = producto; 
    }
    public void setCantidad(Integer cantidad) { 
        this.cantidad = cantidad; 
    }
    public void setTotal(Double total) { 
        this.total = total; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
}