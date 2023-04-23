package org.argentinaprograma.TPIntegradorF;

import static org.argentinaprograma.TPIntegradorF.ConectarSQL.DB_URL;
import static org.argentinaprograma.TPIntegradorF.ConectarSQL.PASS;
import static org.argentinaprograma.TPIntegradorF.ConectarSQL.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLPronostico {
	
	public static void main( String[] args ) {

		String Persona;
		String Equipo1;
		String Equipo2;
		Integer Decision;
		
		Connection conexion = null;
        Statement consulta = null;
    	

         try {
        	 

             conexion = DriverManager.getConnection(DB_URL, USER, PASS);

             // Ejecutar una consulta
             consulta = conexion.createStatement();
             String sqlPronostico;
             sqlPronostico = "SELECT * FROM Pronosticos";
         

             //En la variable resultado obtendremos las distintas filas que nos devolvió la base
             ResultSet resultadoPronosticos = consulta.executeQuery(sqlPronostico);
           

             // Obtener las distintas filas de la consulta
             while (resultadoPronosticos.next()) {
                 // Pbtener el valor de cada columna
                 
                 Persona = resultadoPronosticos.getString("Persona");
                 Equipo1 = resultadoPronosticos.getString("Equipo1");
                 Equipo2 = resultadoPronosticos.getString("Equipo2");
                 Decision = resultadoPronosticos.getInt("Decision");
               

                 // Mostrar los valores obtenidos
                 System.out.println(Persona + " | " + Equipo1 + " | " + Equipo2 + " | " + Decision);
                 
            
            
             }
                          
         
             // Esto se utiliza par cerrar la conexión con la base de datos
             resultadoPronosticos.close();
             consulta.close();
             conexion.close();
         } catch (SQLException se) {
             // Execpción ante problemas de conexión
             se.printStackTrace();
         } finally {
             // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
             try {
                 if (consulta != null)
                     consulta.close();
             } catch (SQLException se2) {
             }
             try {
                 if (conexion != null)
                     conexion.close();
             } catch (SQLException se) {
                 se.printStackTrace();
             }
         }
         
	}
	
 }



