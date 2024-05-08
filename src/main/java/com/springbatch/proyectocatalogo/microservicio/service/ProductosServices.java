package com.springbatch.proyectocatalogo.microservicio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbatch.proyectocatalogo.microservicio.model.Productos;

@Service
public interface ProductosServices {

	/**
	 * Obtiene el catálogo de productos.
	 *
	 * @return Una lista de objetos {@link Productos} que representan el catálogo de
	 *         productos.
	 */
	List<Productos> catalogo();
}
