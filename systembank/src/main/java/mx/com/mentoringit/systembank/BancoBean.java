package mx.com.mentoringit.systembank;

import java.util.ArrayList;

import mx.com.mentoringit.systembank.daos.BancoDAOImpl;
import mx.com.mentoringit.systembank.dtos.BancoDTO;
import mx.com.mentoringit.systembank.interfaces.IBanco;

public class BancoBean {

	public ArrayList<BancoDTO> getBancos() {

		ArrayList<BancoDTO> bancos = null;

		IBanco bancoDAO = new BancoDAOImpl();
		try {
			bancos = bancoDAO.leer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bancos;
	}

	public boolean guardarBanco(BancoDTO bancoDTO) {

		IBanco bancoDAO = new BancoDAOImpl();
		boolean result = false;
		try {
			result = bancoDAO.insertar(bancoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}