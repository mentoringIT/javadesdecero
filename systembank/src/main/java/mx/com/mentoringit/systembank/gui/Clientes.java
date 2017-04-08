package mx.com.mentoringit.systembank.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mx.com.mentoringit.systembank.ClienteBean;
import mx.com.mentoringit.systembank.dtos.ClienteDTO;
import mx.com.mentoringit.systembank.gui.models.ModelClientes;
import mx.com.mentoringit.systembank.process.ExportarClientes;

public class Clientes extends JInternalFrame {

	private static int counter;
	private JTable table;
	private JFrame admin;
	private ArrayList<ClienteDTO> clientes;
	private ModelClientes modelClientes;
	private JButton btnBorrar;
	private int idClienteSelected;

	/**
	 * Create the frame.
	 */
	public Clientes() {
		setResizable(true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				counter--;
			}
		});

		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 59, 394, 144);
		getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveOrUpdate();
			}
		});
		btnGuardar.setBounds(245, 215, 81, 25);
		getContentPane().add(btnGuardar);

		JButton btnNuevo = new JButton("Nuevo");
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoCliente();
			}
		});
		btnNuevo.setBounds(158, 215, 75, 25);
		getContentPane().add(btnNuevo);

		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ExportarClientes exportar = 
						new ExportarClientes(table, table.getParent());
				
				Thread exportThread = new Thread(exportar);
				exportThread.start();
//				
				//exportado de datos sin Thread
//				boolean result = exportar.exportarClientes();
//				
//				if(result){
//					JOptionPane.
//					showMessageDialog(null, "Exportado de datos correcto");
//				}else{
//					JOptionPane.
//					showMessageDialog(null, "Exportado de datos incorrecto");					
//				}
			}
		});
		btnExportar.setBounds(65, 215, 81, 25);
		getContentPane().add(btnExportar);
		
		btnBorrar = new JButton("borrar");
		btnBorrar.setEnabled(false);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCliente();
			}
		});
		btnBorrar.setBounds(337, 215, 69, 25);
		getContentPane().add(btnBorrar);
		counter++;
		obtenerClientes();
	}


	protected void borrarCliente() {
		ClienteDTO dto = new ClienteDTO();

		idClienteSelected = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());

		
		dto.setIdCliente(idClienteSelected);
		
		ClienteBean cteBean = new ClienteBean();
		
		boolean result = cteBean.borrar(dto);
		
		if(result){
			JOptionPane.showMessageDialog(admin, "borrado");
		}else{			
			JOptionPane.showMessageDialog(admin, "no borrado");
		}
		obtenerClientes();
	}


	protected void nuevoCliente() {
		NuevoCliente nuevoCliente = new NuevoCliente();
		this.getParent().add(nuevoCliente);
		nuevoCliente.setVisible(true);
		
		nuevoCliente.setClientes(this);
		
	}

	protected void saveOrUpdate() {
		for (int i = 0; i < clientes.size(); i++) {
			if (modelClientes.getIdClientesUpdate().get(
					clientes.get(i).getIdCliente()) != null) {
				Map<Integer, ClienteDTO> mapaclientes = modelClientes
						.getIdClientesUpdate();

				System.out.println(mapaclientes.get(clientes.get(i)
						.getIdCliente()));

				break;
			}
		}
	}

	void obtenerClientes() {

		ClienteBean cteBean = new ClienteBean();
		clientes = cteBean.getClientes();
		if (clientes != null) {

			setDataToGrid(clientes);

		} else {

			JOptionPane.showMessageDialog(admin, "Sistema no disponible");

		}
	}

	private void setDataToGrid(ArrayList<ClienteDTO> clientes) {

		modelClientes = new ModelClientes(new String[] { "idCliente", "Nobre",
				"A. Paterno", "A. Materno", "Edad" }, 0);

		for (int i = 0; i < clientes.size(); i++) {
			modelClientes.addRow(new String[] {
					"" + clientes.get(i).getIdCliente(),
					clientes.get(i).getNombre(), clientes.get(i).getApaterno(),
					clientes.get(i).getAmaterno(),
					"" + clientes.get(i).getEdad() });
		}

		table.setModel(modelClientes);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnBorrar.setEnabled(true);		
			}
		});
	}

	public static int getCounter() {
		return counter;
	}

	public JFrame getAdmin() {
		return admin;
	}

	public void setAdmin(JFrame admin) {
		this.admin = admin;
	}
}
