package com.example.demo;
public class Patron {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int id;
    private String padre;
    private String uso;

    // Constructor
    public Patron(String codigo, String nombre, String descripcion, int id, String padre, String uso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.padre = padre;
        this.uso = uso;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }
}