package mx.com.mentoringit.systembank.gui.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import mx.com.mentoringit.systembank.dtos.ClienteDTO;

public class ModelClientes extends DefaultTableModel {
	private Map<Integer,ClienteDTO> idClientesUpdate = new HashMap<Integer, ClienteDTO>();

	public ModelClientes(String[] strings, int i) {

		super(strings, i);

	}

	@Override
	public void fireTableCellUpdated(int row, int column) {
		super.fireTableCellUpdated(row, column);
		
		idClientesUpdate.put(
				Integer.parseInt(this.getValueAt(row, 0).toString()),
				getClienteDTO(this.getValueAt(row, column),column));
	
	}

	private ClienteDTO getClienteDTO(Object valueAt,int col) {
		
		switch (col) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;

		default:
			break;
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// return super.isCellEditable(row, column);
		if (column == 0) {
			return false;
		} else {
			return true;
		}

	}

	public Map<Integer, ClienteDTO> getIdClientesUpdate() {
		return idClientesUpdate;
	}

	public void setIdClientesUpdate(Map<Integer, ClienteDTO> idClientesUpdate) {
		this.idClientesUpdate = idClientesUpdate;
	}
}