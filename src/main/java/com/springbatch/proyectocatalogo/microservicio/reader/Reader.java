package com.springbatch.proyectocatalogo.microservicio.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbatch.proyectocatalogo.microservicio.model.Productos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Reader {

	public List<Productos> readCsvFiles() throws IOException {
		List<Productos> productosList = new ArrayList<>();

		List<Productos> productosFromFirstCsv = readCsv(
				"C:\\Users\\6003036\\Documents\\proyectos de Eclipse\\catalogo\\src\\main\\resources\\outputProductos.csv");
		List<Productos> productosFromSecondCsv = anotherReadCsv(
				"C:\\Users\\6003036\\Documents\\proyectos de Eclipse\\catalogo\\src\\main\\resources\\outputStock.csv");

		int maxSize = Math.min(productosFromFirstCsv.size(), productosFromSecondCsv.size());
		for (int i = 0; i < maxSize; i++) {
			Productos productoFromFirstCsv = productosFromFirstCsv.get(i);
			Productos productoFromSecondCsv = productosFromSecondCsv.get(i);

			Productos productoMerged = new Productos();
			productoMerged.setId(productoFromSecondCsv.getId());
			productoMerged.setLugar(productoFromSecondCsv.getLugar());
			productoMerged.setStock(productoFromSecondCsv.getStock());
			productoMerged.setStockReal(productoFromSecondCsv.getStockReal());
			productoMerged.setStockVirtual(productoFromSecondCsv.getStockVirtual());
			productoMerged.setCodigo(productoFromFirstCsv.getCodigo());
			productoMerged.setNombre(productoFromFirstCsv.getNombre());

			productosList.add(productoMerged);
		}

		return productosList;
	}

	private List<Productos> readCsv(String filePath) throws IOException {
		List<Productos> productosList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				Productos producto = new Productos();
				if (fields.length == 4) {
					producto.setCodigo(Long.parseLong(fields[3].trim()));
					producto.setNombre(fields[0].trim());
					productosList.add(producto);
				}

				else {
					log.error("Error: Número de campos incorrecto en la línea: " + line);
				}
			}
		}
		return productosList;
	}

	private List<Productos> anotherReadCsv(String filePath) throws IOException {

		List<Productos> productosList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				Productos producto = new Productos();
				if (fields.length == 5) {
					producto.setId(Long.parseLong(fields[1].trim()));
					producto.setLugar(fields[0]);
					producto.setStock(Long.parseLong(fields[2].trim()));
					producto.setStockReal(Long.parseLong(fields[3].trim()));
					producto.setStockVirtual(Long.parseLong(fields[4].trim()));
					productosList.add(producto);
				} else {
					log.error("Error 2: Número de campos incorrecto en la línea: \" + line");
				}
			}
		}
		return productosList;
	}

}
