package mx.com.mentoringit.systembank.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import mx.com.mentoringit.systembank.BancoBean;
import mx.com.mentoringit.systembank.ClienteBean;
import mx.com.mentoringit.systembank.dtos.BancoDTO;
import mx.com.mentoringit.systembank.dtos.ClienteDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoCliente extends JInternalFrame {
	private JTextField txtnombre;
	private JTextField txtapaterno;
	private JTextField txtamaterno;
	private JTextField txtedad;
	private ArrayList<BancoDTO> bancos;
	private JComboBox cmbBancos;
	private Clientes clientes;

	/**
	 * Create the frame.
	 */
	public NuevoCliente() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Nuevo cliente");
		setBounds(100, 100, 351, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(75, 45, 62, 22);
		getContentPane().add(lblNewLabel);

		txtnombre = new JTextField();
		txtnombre.setBounds(159, 45, 116, 22);
		getContentPane().add(txtnombre);
		txtnombre.setColumns(10);

		JLabel lblApaterno = new JLabel("Apaterno:");
		lblApaterno.setBounds(75, 73, 62, 22);
		getContentPane().add(lblApaterno);

		JLabel lblAmaterno = new JLabel("Amaterno:");
		lblAmaterno.setBounds(75, 97, 62, 22);
		getContentPane().add(lblAmaterno);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(75, 121, 62, 22);
		getContentPane().add(lblEdad);

		JLabel lblBanco = new JLabel("Banco:");
		lblBanco.setBounds(75, 158, 62, 22);
		getContentPane().add(lblBanco);

		txtapaterno = new JTextField();
		txtapaterno.setColumns(10);
		txtapaterno.setBounds(159, 73, 116, 22);
		getContentPane().add(txtapaterno);

		txtamaterno = new JTextField();
		txtamaterno.setColumns(10);
		txtamaterno.setBounds(159, 97, 116, 22);
		getContentPane().add(txtamaterno);

		txtedad = new JTextField();
		txtedad.setColumns(10);
		txtedad.setBounds(159, 121, 116, 22);
		getContentPane().add(txtedad);

		cmbBancos = new JComboBox();
		cmbBancos.setBounds(159, 158, 116, 22);
		getContentPane().add(cmbBancos);


		JButton btnGuardar = new JButton("guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCliente();
			}
		});
		btnGuardar.setBounds(178, 193, 97, 25);
		getContentPane().add(btnGuardar);

		listarBancos();
	}

	protected void guardarCliente() {
		
		ClienteBean clienteBean = new ClienteBean();
		
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setNombre(txtnombre.getText());
		clienteDTO.setApaterno(txtapaterno.getText());
		clienteDTO.setAmaterno(txtamaterno.getText());
		clienteDTO.setEdad(Integer.parseInt(txtedad.getText()));
		
		int idbanco = (
						(BancoDTO)
						cmbBancos.getModel().getSelectedItem()
						).getIdBanco();
		
		clienteDTO.setIdBanco(idbanco);
		
		clienteBean.guardarCliente(clienteDTO);
		clientes.obtenerClientes();
		
	}

	private void listarBancos() {
		BancoBean bancoBean = new BancoBean();
		bancos = bancoBean.getBancos();
		updateComboBancos();
	}

	private void updateComboBancos() {
		DefaultComboBoxModel<BancoDTO> modelCombo = new DefaultComboBoxModel<BancoDTO>();

		for (BancoDTO banco : bancos) {
			modelCombo.addElement(banco);
		}
		cmbBancos.setModel(modelCombo);
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
}