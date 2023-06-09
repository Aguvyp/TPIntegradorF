package org.argentinaprograma.TPIntegradorF.models;

import org.argentinaprograma.TPIntegradorF.EnumResultado;

import com.opencsv.bean.CsvBindByPosition;

public class ArchPronostico {

	@CsvBindByPosition(position = 0)
	private String persona;
	
	@CsvBindByPosition(position = 1)
	private String equipo1;
	
	@CsvBindByPosition(position = 2)
	private String gana1;
	
	@CsvBindByPosition(position = 3)
	private String empata;
	
	@CsvBindByPosition(position = 4)
	private String gana2;
	
	@CsvBindByPosition(position = 5)
	private String equipo2;
	
	public EnumResultado ganaOPierdeOEmpata1() {
		if(this.gana1.equals("X")) {
			return EnumResultado.GANADOR;
		}
		if(this.gana2.equals("X")) {
			return EnumResultado.PERDEDOR;
		}
		
		return EnumResultado.EMPATE;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getGana1() {
		return gana1;
	}

	public void setGana1(String gana1) {
		this.gana1 = gana1;
	}

	public String getEmpata() {
		return empata;
	}

	public void setEmpata(String empata) {
		this.empata = empata;
	}

	public String getGana2() {
		return gana2;
	}

	public void setGana2(String gana2) {
		this.gana2 = gana2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
	
	
}
