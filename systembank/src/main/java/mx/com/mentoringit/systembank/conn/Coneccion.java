package mx.com.mentoringit.systembank.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Coneccion {

	private static Coneccion instance;

	private String usr;
	private String pwd;
	private String url;
	private String bd;
	private String server;

	private InputStream input = null;
	Properties dbaccess = new Properties();

	// constructor privado impide crear objetos desde fuera de la clase
	private Coneccion() {
		System.out.println("Creando conexion");

		if (loadDbAccessProps()) {
			usr = dbaccess.getProperty("usr");
			pwd = dbaccess.getProperty("pwd");
			bd = dbaccess.getProperty("bd");
			server = dbaccess.getProperty("server");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Driver no encontrado");
			}

		} else {
			System.out.println("Error al cargar el archivo de proiedades");
		}

	}
	
	public boolean loadDbAccessProps() {
		boolean result = false;

		// cargarmos archivo de propiedades
		try {
			input = this.getClass().getResourceAsStream("dbaccess.properties");
			dbaccess.load(input);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		return result;

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
			conect = DriverManager.getConnection(server + bd, usr, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conect;
	}
}
