package com.springbatch.proyectocatalogo.microservicio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbatch.proyectocatalogo.microservicio.model.Productos;

@Service
public interface ProductosServices {

	List<Productos> catalogo();
}
