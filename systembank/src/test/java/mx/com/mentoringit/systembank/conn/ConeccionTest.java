package mx.com.mentoringit.systembank.conn;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConeccionTest {

	@Test
	public void testGetConexion() {
		
		assertNotNull(Coneccion.getInstance().getConexion());
		
	}

}