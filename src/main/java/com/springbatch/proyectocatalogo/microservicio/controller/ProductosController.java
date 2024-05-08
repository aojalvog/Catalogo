package com.springbatch.proyectocatalogo.microservicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbatch.proyectocatalogo.microservicio.model.Productos;
import com.springbatch.proyectocatalogo.microservicio.service.ProductosServices;

@RestController
public class ProductosController {

	@Autowired
	ProductosServices productosServices;

	@GetMapping("/getCatalogo")
	public List<Productos> getCatalogo() {
		return productosServices.catalogo();
	}
}
