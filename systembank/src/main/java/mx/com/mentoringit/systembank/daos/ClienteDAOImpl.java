package mx.com.mentoringit.systembank.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mx.com.mentoringit.systembank.conn.Coneccion;
import mx.com.mentoringit.systembank.dtos.ClienteDTO;
import mx.com.mentoringit.systembank.interfaces.ICliente;

public class ClienteDAOImpl implements ICliente {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public boolean actualiza(ClienteDTO clienteDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean borrar(ClienteDTO clienteDTO) throws Exception {
		String delete = "delete from cliente where idcliente = ?";

		con = Coneccion.getInstance().getConexion();
		ps = con.prepareStatement(delete);

		ps.setInt(1, clienteDTO.getIdCliente());

		ps.execute();

		boolean result = ps.getUpdateCount() > 0;

		con.close();
		
		return result;
	}

	public ClienteDTO buscar(ClienteDTO clienteDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ClienteDTO> leer() throws Exception {
		con = Coneccion.getInstance().getConexion();
		String select = "select * from cliente";

		ps = con.prepareStatement(select);
		rs = ps.executeQuery();

		ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

		while (rs.next()) {
			ClienteDTO dto = new ClienteDTO();
			dto.setIdCliente(rs.getInt("idcliente"));
			dto.setNombre(rs.getString("nombre").toLowerCase());
			dto.setApaterno(rs.getString("apaterno").toLowerCase());
			dto.setAmaterno(rs.getString("amaterno").toLowerCase());
			dto.setEdad(rs.getInt("edad"));
			dto.setIdBanco(rs.getInt("idBanco"));
			clientes.add(dto);
		}

		con.close();

		return clientes;
	}

	public boolean insertar(ClienteDTO clienteDTO) throws Exception {
		String insert = "insert into "
				+ "cliente(nombre,apaterno,amaterno,edad,idbanco) "
				+ "values(?,?,?,?,?)";

		con = Coneccion.getInstance().getConexion();
		ps = con.prepareStatement(insert);

		ps.setString(1, clienteDTO.getNombre());
		ps.setString(2, clienteDTO.getApaterno());
		ps.setString(3, clienteDTO.getAmaterno());

		ps.setInt(4, clienteDTO.getEdad());
		ps.setInt(5, clienteDTO.getIdBanco());

		ps.execute();

		boolean result = ps.getUpdateCount() > 0;

		con.close();
		
		return result;
	}

}
