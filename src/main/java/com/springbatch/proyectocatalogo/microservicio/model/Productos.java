package com.springbatch.proyectocatalogo.microservicio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Productos {

	private Long id;
	private String lugar;
	private Long stock;
	private Long stockReal;
	private Long stockVirtual;
	private Long codigo;
	private String nombre;

}
