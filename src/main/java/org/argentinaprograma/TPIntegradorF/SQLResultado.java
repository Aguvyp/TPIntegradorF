package org.argentinaprograma.TPIntegradorF;

import static org.argentinaprograma.TPIntegradorF.ConectarSQL.DB_URL;
import static org.argentinaprograma.TPIntegradorF.ConectarSQL.PASS;
import static org.argentinaprograma.TPIntegradorF.ConectarSQL.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLResultado {
	public static void main( String[] args ) {
		
	
	String Ronda;
	String Equipo1;
	String Equipo2;
	Integer Goles1;
	Integer Goles2;

	{
		
		 
		Connection conexion = null;
         Statement consulta = null;

         try {

             conexion = DriverManager.getConnection(DB_URL, USER, PASS);

             // Ejecutar una consulta
             consulta = conexion.createStatement();
             String sqlResultados;
            
             sqlResultados = "SELECT * FROM Resultados";

             //En la variable resultado obtendremos las distintas filas que nos devolvió la base
          
             ResultSet resultadoResultados = consulta.executeQuery(sqlResultados);

             // Obtener las distintas filas de la consulta
             while (resultadoResultados.next()) {
            	 Ronda = resultadoResultados.getString("Ronda");
            	 Equipo1 = resultadoResultados.getString("Equipo1");
            	 Goles1 = resultadoResultados.getInt("Goles1");
            	 Goles2 = resultadoResultados.getInt("Goles2");
            	 Equipo2 = resultadoResultados.getString("Equipo2");
            	 
            	 System.out.println(Ronda + " | " + Equipo1 + " | " + Goles1 + " | " + Goles2 + " | " + Equipo2 );
    
             }
                          
         
             // Esto se utiliza par cerrar la conexión con la base de datos
             resultadoResultados.close();
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
}

