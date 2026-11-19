package com.antobano.repositorio;

import com.antobano.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz Repositorio para gestionar las operaciones CRUD de Producto.
 * Extiende de JpaRepository para heredar metodos como findAll(), save() y deleteById().
 * 
 * @author Andres Santiago Moncada Duarte
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
