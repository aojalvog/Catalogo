package com.springbatch.proyectocatalogo.microservicio.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.exceptions.CsvValidationException;
import com.springbatch.proyectocatalogo.microservicio.model.Productos;

@Service
public class Reader {

	public List<Productos> readCsvFiles() throws IOException, CsvValidationException {
		List<Productos> productosList = new ArrayList<>();

		List<Productos> productosFromFirstCsv = readCsv(
				"C:\\Users\\6003036\\Documents\\proyectos de Eclipse\\catalogo\\src\\main\\resources\\outputProductos.csv");
		List<Productos> productosFromSecondCsv = anotherReadCsv(
				"C:\\Users\\6003036\\Documents\\proyectos de Eclipse\\catalogo\\src\\main\\resources\\outputStock.csv");

		int maxSize = Math.min(productosFromFirstCsv.size(), productosFromSecondCsv.size());
		for (int i = 0; i < maxSize; i++) {
			Productos productoFromFirstCsv = productosFromFirstCsv.get(i);
			Productos productoFromSecondCsv = productosFromSecondCsv.get(i);

			// Crear un nuevo objeto Producto que combina los campos de ambos objetos
			Productos productoMerged = new Productos();
			productoMerged.setId(productoFromSecondCsv.getId());
			productoMerged.setLugar(productoFromSecondCsv.getLugar());
			productoMerged.setStock(productoFromSecondCsv.getStock());
			productoMerged.setStockReal(productoFromSecondCsv.getStockReal());
			productoMerged.setStockVirtual(productoFromSecondCsv.getStockVirtual());
			productoMerged.setCodigo(productoFromFirstCsv.getCodigo());
			productoMerged.setNombre(productoFromFirstCsv.getNombre());

			// Agregar el objeto combinado a la lista final
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
				// Aquí debes verificar que el número de campos es correcto antes de acceder a
				// ellos
				if (fields.length == 4) {
					producto.setCodigo(Long.parseLong(fields[3].trim())); // Suponiendo que el id está en el primer
																			// campo
					producto.setNombre(fields[0].trim());
					productosList.add(producto);
				}

				else {
					// Manejar el caso donde el número de campos no es el esperado
					System.err.println("Error: Número de campos incorrecto en la línea: " + line);
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
					System.err.println("Error2: Número de campos incorrecto en la línea: \" + line");
				}
			}
		}
		return productosList;
	}

}
