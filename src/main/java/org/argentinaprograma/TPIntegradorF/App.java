package org.argentinaprograma.TPIntegradorF;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.argentinaprograma.TPIntegradorF.models.ArchPronostico;
import org.argentinaprograma.TPIntegradorF.models.ArchResultado;

public class App 
{
    public static void main( String[] args )
    {
    	LeerArchivos leerArch = new LeerArchivos();
    	
        leerArch.parsearResultados("java/main/resources/Resultados.csv");
        List<ArchResultado>listaDeResultados = leerArch.listaDeResultados;
        
        leerArch.parsearPronosticos("java/main/resources/Pronosticos.csv");
        List<ArchPronostico>listaDePronosticos = leerArch.listaDePronosticos;
        
        Map<String, Integer>puntosParticipantes = new HashMap<String, Integer>();
        
        for(ArchPronostico pronostico : listaDePronosticos) {
        	
        	if(!puntosParticipantes.containsKey(pronostico.getPersona())) {
        		puntosParticipantes.put(pronostico.getPersona(), 0);
        	}
        
        	for(ArchResultado resultado : listaDeResultados) {
        		if(resultado.getEquipo1().equalsIgnoreCase(pronostico.getEquipo1())
        				&& resultado.getEquipo2().equalsIgnoreCase(pronostico.getEquipo2())){
        		
        			if(resultado.ganaOPierdeOEmpata1() == pronostico.ganaOPierdeOEmpata1()) {
        				puntosParticipantes.put(pronostico.getPersona(), puntosParticipantes.get(pronostico.getPersona())+1);
        			}
        		}
        	}
        }
        
    
        for(String personas : puntosParticipantes.keySet()) {
        	System.out.println(personas+": "+puntosParticipantes.get(personas));
        }
    }
}
