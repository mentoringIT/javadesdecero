package mx.com.mentoringit.systembank.dtos;

public class BancoDTO implements Comparable<BancoDTO> {

	@Override
	public String toString() {
		return  idBanco + ".-" + nombre;
	}

	private int idBanco;
	private String nombre;

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int compareTo(BancoDTO o) {
		int result = 0;

		result = this.nombre.compareTo(o.getNombre());
		return result;
	}
}
