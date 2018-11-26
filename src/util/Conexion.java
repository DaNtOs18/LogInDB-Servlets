package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Conexion {
	private String host;
	private String bd;
	private String usr;
	private String clave;
	private static Connection conexion;

	public static Connection conectar(String host, String bd, String usr, String clave) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + host + "/" + bd + "?useSSL=false";
			conexion = DriverManager.getConnection(url, usr, clave);
		} catch (SQLException e) {
			System.out.println("Error sql -> " + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("Error carga del driver -> " + e.getMessage());
		}

		return conexion;
	}

	public static Boolean logIng(String usuario, String contrasena) {

		String sql = "SELECT * FROM `usuarios` WHERE usuario=" + "'" + usuario + "' AND clave=" + "'" + contrasena + "'";
		Boolean log = null;
		
		try {
			conexion = conectar("localhost:3306", "log", "root", "");
			Statement stmt = conexion.createStatement();
			ResultSet rS = stmt.executeQuery(sql);
			// ResultSetMetaData metaData = rS.getMetaData();

			 if (!rS.first()) {
				 log = false;
			 }
			 
			 else {
				 log = true;
			 }
		

		} catch (SQLException e) {
			log = false;
			System.out.println("Error leyendo Bases de Datos -> " + e.getMessage());
		}
		return log;
		
		

	}
}
