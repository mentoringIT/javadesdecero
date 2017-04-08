package mx.com.mentoringit.systembank.process;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExportarClientes implements Runnable {

	private JTable table;
	private Component component;

	private final String DIRECTORIO = "\\exportedClientes";
	private final String ARCHIVO = "\\clientes.csv";

	/**
	 * @param table
	 *            una referencia de la tabla a exportar a un excel
	 * @param component
	 *            es una referemcia de la pantalla que genero el proceso de
	 *            escribir el archivo al disco
	 */

	public ExportarClientes(JTable table, Component component) {
		this.table = table;
		this.component = component;
	}

	public boolean exportarClientes() {
		boolean result = false;

		// verificamos si el directorio existe
		boolean dirExist = new File(DIRECTORIO).exists();

		if (!dirExist) {
			File file = new File(DIRECTORIO);
			file.mkdir();
		}

		try {
			// creamos el archivo dentro de nuestro directorio
			FileWriter fw = new FileWriter(DIRECTORIO + ARCHIVO);
			PrintWriter pw = new PrintWriter(fw);

			DefaultTableModel modeloGrid = (DefaultTableModel) table.getModel();

			int columnas = modeloGrid.getColumnCount();
			int filas = modeloGrid.getRowCount();

			for (int count = 0; count < 500000; count++) {
				
				for (int i = 0; i < filas; i++) {
					for (int j = 0; j < columnas; j++) {
						if (j == columnas - 1) {
							pw.println(modeloGrid.getValueAt(i, j));
						} else {
							pw.print(modeloGrid.getValueAt(i, j) + ",");
						}
					}
				}
				
			}
			pw.close();
			fw.close();
			result = true;

		} catch (IOException e) {
			e.printStackTrace();
			result = false;
			String msg = "Ocurrio un error en el sistema!";
			JOptionPane.showMessageDialog(this.component, msg);
		}

		return result;
	}

	public void run() {
		boolean result = exportarClientes();
		String msg = "";
		if (result) {
			msg = "Datos exportados correctamente!";
		} else {
			msg = "Proceso no terminado, comunicarse a sistemas!";
		}
		JOptionPane.showMessageDialog(this.component, msg);
	}

}