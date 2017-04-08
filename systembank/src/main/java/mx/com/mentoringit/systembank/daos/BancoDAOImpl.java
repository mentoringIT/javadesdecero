package mx.com.mentoringit.systembank.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import mx.com.mentoringit.systembank.conn.Coneccion;
import mx.com.mentoringit.systembank.dtos.BancoDTO;
import mx.com.mentoringit.systembank.interfaces.IBanco;

public class BancoDAOImpl implements IBanco {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public boolean actualiza(BancoDTO bancoDTO) throws Exception {
		return false;
	}

	public boolean borrar(BancoDTO bancoDTO) throws Exception {
		return false;
	}

	public BancoDTO buscar(BancoDTO bancoDTO) throws Exception {
		return null;
	}

	public ArrayList<BancoDTO> leer() throws Exception {
		con = Coneccion.getInstance().getConexion();
		String select = "select * from banco";

		ps = con.prepareStatement(select);
		rs = ps.executeQuery();

		ArrayList<BancoDTO> bancos = new ArrayList<BancoDTO>();
		TreeSet<BancoDTO> bancosOrdenados = new TreeSet<BancoDTO>();

		while (rs.next()) {
			BancoDTO dto = new BancoDTO();
			dto.setIdBanco(rs.getInt("idbanco"));
			dto.setNombre(rs.getString("nombre").toLowerCase());
			bancos.add(dto);
			bancosOrdenados.add(dto);
		}
		
		con.close();
		for (Object bancoDTO : bancosOrdenados.toArray()) {

			System.out.println(((BancoDTO) bancoDTO).getIdBanco() + " "
					+ ((BancoDTO) bancoDTO).getNombre());
		}
		return bancos;
	}

	public boolean insertar(BancoDTO bancoDTO) throws Exception {
		boolean result = false;

		con = Coneccion.getInstance().getConexion();

		String insert = "INSERT INTO banco(nombre) VALUES (?)";

		ps = con.prepareStatement(insert);
		ps.setString(1, bancoDTO.getNombre());

		int res = ps.executeUpdate();

		if (res == 1) {
			result = true;
		}
		con.close();

		return result;
	}
}