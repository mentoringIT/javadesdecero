package mx.com.mentoringit.systembank.daos;

import java.util.ArrayList;

import mx.com.mentoringit.systembank.dtos.BancoDTO;
import mx.com.mentoringit.systembank.interfaces.IBanco;

public class BancoDAOImpTEXT implements IBanco {

	public boolean actualiza(BancoDTO bancoDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean borrar(BancoDTO bancoDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public BancoDTO buscar(BancoDTO bancoDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BancoDTO> leer() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertar(BancoDTO bancoDTO) throws Exception {
		System.out.println("Escribiendo en excel");

		return true;
	}

}
