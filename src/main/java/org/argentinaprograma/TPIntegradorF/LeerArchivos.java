package org.argentinaprograma.TPIntegradorF;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.argentinaprograma.TPIntegradorF.models.ArchPronostico;
import org.argentinaprograma.TPIntegradorF.models.ArchResultado;

import com.opencsv.bean.CsvToBeanBuilder;

public class LeerArchivos {

	String rutaArchivo;
	
	public List<ArchResultado> listaDeResultados;
	public List<ArchPronostico> listaDePronosticos;
	
	public LeerArchivos(){
		this.listaDeResultados = new ArrayList<ArchResultado>();
		this.listaDePronosticos = new ArrayList<ArchPronostico>();
		
	}

	
	public void parsearResultados(String rutaDelArchivoResultado) {
		List<ArchResultado> listaDeResultados = null;
		try {
			listaDeResultados = new CsvToBeanBuilder<ArchResultado>(new FileReader(rutaDelArchivoResultado))
					.withSkipLines(1)
					.withSeparator(',')
					.withType(ArchResultado.class)
					.build()
					.parse();
		}catch (IOException e) {
	        e.printStackTrace();
		}
		this.listaDeResultados = listaDeResultados;
	}
	
	public void parsearPronosticos(String rutaDelArchivoPronostico) {
		List<ArchPronostico> listaDePronosticos = null;
		try {
			listaDePronosticos = new CsvToBeanBuilder<ArchPronostico>(new FileReader(rutaDelArchivoPronostico))
					.withSkipLines(1)
					.withSeparator(',')
					.withType(ArchPronostico.class)
					.build()
					.parse();
		}catch (IOException e) {
	        e.printStackTrace();
		}
		this.listaDePronosticos = listaDePronosticos;
	}
	
	
}
