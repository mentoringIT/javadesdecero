package mx.com.mentoringit.systembank.daos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteDAOTest {

	@Test
	public void testLeer() {
		try {
			
			assertTrue(new ClienteDAOImpl().leer().size() > 0);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
