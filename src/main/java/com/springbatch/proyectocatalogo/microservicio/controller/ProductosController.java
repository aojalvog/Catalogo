package com.springbatch.proyectocatalogo.microservicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbatch.proyectocatalogo.microservicio.model.Productos;
import com.springbatch.proyectocatalogo.microservicio.service.ProductosServices;

/**
 * Este es el controller de Productos donde vamos a dejar los /endPoints
 */
@RestController
public class ProductosController {

	/**
	 * Inyectamos la clase de productosServices
	 */
	@Autowired
	ProductosServices productosServices;

	/**
	 * Creación del endpoint /getCatalogo
	 * 
	 * @return lista de todos los productos que hay en el catálogo
	 */
	@GetMapping("/getCatalogo")
	public List<Productos> getCatalogo() {
		return productosServices.catalogo();
	}
}
