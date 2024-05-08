package com.springbatch.proyectocatalogo.microservicio.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.springbatch.proyectocatalogo.microservicio.model.Productos;

public class Reader {

	public static List<Productos> reader() {
		List<Productos> list = null;

		CSVReader reader = null;
		InputStream inputStream;

		try {
			File initialFile = new File("outputProductos.csv");
			inputStream = new FileInputStream(initialFile);
			reader = new CSVReader(new InputStreamReader(inputStream));
			ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
			strat.setType(Productos.class);
			String[] columns = new String[] { "name", "code" };
			strat.setColumnMapping(columns);
			CsvToBean csv = new CsvToBean();
			list = csv.parse(strat, reader);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			reader.close();
		}
		return list;
	}
}
