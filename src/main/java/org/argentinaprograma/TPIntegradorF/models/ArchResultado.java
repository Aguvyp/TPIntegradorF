package org.argentinaprograma.TPIntegradorF.models;

import org.argentinaprograma.TPIntegradorF.EnumResultado;

import com.opencsv.bean.CsvBindByPosition;

public class ArchResultado {
	
	@CsvBindByPosition(position = 0)
	private Integer ronda;
	
	@CsvBindByPosition(position = 1)
	private String equipo1;
	
	@CsvBindByPosition(position = 2)
	private Integer golesEq1;
	
	@CsvBindByPosition(position = 3)
	private Integer golesEq2;
	
	@CsvBindByPosition(position = 4)
	private String equipo2;
	
	public EnumResultado  ganaOPierdeOEmpata1() {
		if(this.golesEq1 > this.golesEq2) {
			return EnumResultado.GANADOR;
		}
		if(this.golesEq1 < this.golesEq2) {
			return EnumResultado.PERDEDOR;
		}
		return EnumResultado.EMPATE;
	}

	public Integer getRonda() {
		return ronda;
	}

	public void setRonda(Integer ronda) {
		this.ronda = ronda;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public Integer getGolesEq1() {
		return golesEq1;
	}

	public void setGolesEq1(Integer golesEq1) {
		this.golesEq1 = golesEq1;
	}

	public Integer getGolesEq2() {
		return golesEq2;
	}

	public void setGolesEq2(Integer golesEq2) {
		this.golesEq2 = golesEq2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
}
