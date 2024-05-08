package com.springbatch.proyectocatalogo.microservicio.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbatch.proyectocatalogo.microservicio.model.Productos;
import com.springbatch.proyectocatalogo.microservicio.reader.Reader;

@Service
public class ProductosServiceImpl implements ProductosServices {

	@Autowired
	private Reader reader;

	/**
	 * Obtiene el catálogo de productos.
	 *
	 * @return Una lista de objetos {@link Productos} que representan el catálogo de
	 *         productos. Si ocurre un error durante la lectura del catálogo,
	 *         devuelve null.
	 */

	@Override
	public List<Productos> catalogo() {
		try {
			return reader.readCsvFiles();
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}

}
