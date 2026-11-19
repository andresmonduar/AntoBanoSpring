package com.antobano.controlador;

import com.antobano.modelo.Producto;
import com.antobano.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador web principal del modulo de productos de AntoBano.
 * Gestiona las peticiones HTTP (GET y POST) entre la vista HTML y la base de datos.
 *
 * @author Andres Santiago Moncada Duarte
 */
@Controller
public class ProductoController {

    // Inyeccion automatica del repositorio para interactuar con MySQL
    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Muestra la pagina principal con el formulario vacio y la lista de productos.
     */
    @GetMapping("/")
    public String listarProductos(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaProductos", productoRepository.findAll());
        return "index";
    }

    /**
     * Recibe los datos del formulario HTML y guarda o actualiza el producto en MySQL.
     */
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoRepository.save(producto);
        return "redirect:/";
    }

    /**
     * Carga los datos de un producto existente en el formulario para editarlo.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Producto productoExistente = productoRepository.findById(id).orElse(new Producto());
        model.addAttribute("producto", productoExistente);
        model.addAttribute("listaProductos", productoRepository.findAll());
        return "index";
    }

    /**
     * Elimina un producto de la base de datos segun su identificador.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoRepository.deleteById(id);
        return "redirect:/";
    }
}
