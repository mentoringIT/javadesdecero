package mx.com.mentoringit.systembank.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {

	private static Coneccion instance;

	private String usr;
	private String pwd;
	private String url;
	private String bd;

	// constructor privado impide crear objetos desde fuera de la clase
	private Coneccion() {
		System.out.println("objeto creado");

		usr = "root";
		pwd = "root";
		url = "jdbc:mysql://localhost:3306/";
		bd = "sistemabancario";

		// ponemos en memoria el nombre de la clase
		// a buscar en las librerias para conectarnos a la BD
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * metodo estatico que regresa una 
	 * instancia de Coneccion
	 */
	public static Coneccion getInstance() {

		if (instance == null) {
			instance = new Coneccion();
		}
		return instance;
	}

	public Connection getConexion() {
		Connection conect = null;

		try {
			conect = DriverManager.getConnection(url + bd, usr, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conect;
	}
}
