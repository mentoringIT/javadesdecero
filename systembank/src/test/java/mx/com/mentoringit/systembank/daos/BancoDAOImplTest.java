package mx.com.mentoringit.systembank.daos;

import static org.junit.Assert.*;
import mx.com.mentoringit.systembank.dtos.BancoDTO;
import mx.com.mentoringit.systembank.interfaces.IBanco;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class BancoDAOImplTest {
	
	Logger log = Logger.getLogger(BancoDAOImplTest.class);

	@Ignore
	public void testActualiza() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testBorrar() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testBuscar() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeer() {
		boolean condition;
		try {
			condition = new BancoDAOImpl().leer().size() > 0;

			System.out.println();
			for (BancoDTO iterable_element : new BancoDAOImpl().leer()) {
				System.out.println(iterable_element.getNombre());
			}
			assertTrue(condition);

		} catch (Exception e) {
			log.error(e);
			//e.printStackTrace();
		}
	}

	@Ignore
	public void testInsertar() {
		BancoDTO banco = new BancoDTO();
		banco.setNombre("Caixa Bank Poli");

		boolean condition = false;

		IBanco dao = new BancoDAOImpl();

		try {

			condition = dao.insertar(banco);

		} catch (Exception e) {

			e.printStackTrace();

		}

		assertTrue(condition);
	}

}
