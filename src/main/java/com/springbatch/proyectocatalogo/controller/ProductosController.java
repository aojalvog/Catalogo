package com.springbatch.proyectocatalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbatch.proyectocatalogo.model.Productos;
import com.springbatch.proyectocatalogo.service.ProductosServices;

public class ProductosController {

	@Autowired
	ProductosServices productosServices;

	@GetMapping("/getCatalogo")
	public List<Productos> getCatalogo() {
		return null;
	}
}
