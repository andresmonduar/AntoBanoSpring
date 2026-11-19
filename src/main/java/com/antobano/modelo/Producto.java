package com.antobano.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Modelo que representa un producto del menu de AntoBano.
 * Mapea directamente con la tabla 'productos' en la base de datos MySQL.
 * 
 * @author Andres Santiago Moncada Duarte
 */
@Entity
@Table(name = "productos")
public class Producto {

    // Identificador unico autoincremental del producto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre comercial del producto (ej. Hamburguesa Doble)
    private String nombre;

    // Categoria a la que pertenece (ej. Hamburguesas, Bebidas)
    private String categoria;

    // Precio de venta en pesos colombianos (COP)
    private Double precio;

    // Constructor vacio requerido por el framework Spring Boot / JPA
    public Producto() {
    }

    // Constructor con parametros para facilitar la creacion de objetos
    public Producto(String nombre, String categoria, Double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    // --- Metodos Getters y Setters (Estandar de encapsulamiento) ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
