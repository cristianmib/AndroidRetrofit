package com.example.androidretrofit.models;

public class Producto {
    private String pro_codigo;
    private String pro_nombre;
    private String pro_descripcion;
    private Double pro_precio;

    public String getPro_codigo() {

        return pro_codigo;
    }

    public void setPro_codigo(String pro_codigo) {

        this.pro_codigo = pro_codigo;
    }

    public String getPro_nombre() {

        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {

        this.pro_nombre = pro_nombre;
    }

    public String getPro_descripcion() {

        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public Double getPro_precio() {

        return pro_precio;
    }

    public void setPro_precio(Double pro_precio) {

        this.pro_precio = pro_precio;
    }
}
