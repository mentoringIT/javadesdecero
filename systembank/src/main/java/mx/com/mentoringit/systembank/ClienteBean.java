package mx.com.mentoringit.systembank;

import java.util.ArrayList;

import mx.com.mentoringit.systembank.daos.ClienteDAOImpl;
import mx.com.mentoringit.systembank.dtos.ClienteDTO;
import mx.com.mentoringit.systembank.interfaces.ICliente;

public class ClienteBean {

	public ArrayList<ClienteDTO> getClientes() {
		try {

			ICliente dao = new ClienteDAOImpl();

			return dao.leer();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean guardarCliente(ClienteDTO clienteDTO) {
		ICliente dao = new ClienteDAOImpl();
		boolean result = false;
		try {
			result = dao.insertar(clienteDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean borrar(ClienteDTO dto) {
		ICliente dao = new ClienteDAOImpl();
		boolean result = false;
		try {
			result = dao.borrar(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
