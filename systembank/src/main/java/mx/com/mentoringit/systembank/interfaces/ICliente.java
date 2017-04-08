package mx.com.mentoringit.systembank.interfaces;

import java.util.ArrayList;

import mx.com.mentoringit.systembank.dtos.ClienteDTO;


public interface ICliente {
	boolean actualiza(ClienteDTO clienteDTO) throws Exception;

	boolean borrar(ClienteDTO clienteDTO) throws Exception;

	ClienteDTO buscar(ClienteDTO clienteDTO) throws Exception;

	ArrayList<ClienteDTO> leer() throws Exception;

	boolean insertar(ClienteDTO clienteDTO) throws Exception;

}