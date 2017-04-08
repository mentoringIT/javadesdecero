package mx.com.mentoringit.systembank.interfaces;

import java.util.ArrayList;

import mx.com.mentoringit.systembank.dtos.BancoDTO;

public interface IBanco {

	boolean actualiza(BancoDTO bancoDTO) throws Exception;
	
	boolean borrar(BancoDTO bancoDTO) throws Exception;
	
	BancoDTO buscar(BancoDTO bancoDTO) throws Exception;
	
	ArrayList<BancoDTO> leer() throws Exception;
	
	boolean insertar(BancoDTO bancoDTO) throws Exception;
}