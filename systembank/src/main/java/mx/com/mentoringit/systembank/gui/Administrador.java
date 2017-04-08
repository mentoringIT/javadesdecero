package mx.com.mentoringit.systembank.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Administrador {

	private JFrame frmAdministrador;
	protected int ctesClicked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador window = new Administrador();
					window.frmAdministrador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public Administrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministrador = new JFrame();
		frmAdministrador.setTitle("Administrador");
		frmAdministrador.setBounds(100, 100, 450, 300);
		frmAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmAdministrador.setJMenuBar(menuBar);

		JMenu menuAdmin = new JMenu("Administración");
		menuBar.add(menuAdmin);

		JMenuItem mnuItemClientes = new JMenuItem("Clientes");
		mnuItemClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarClientes();
			}
		});
		menuAdmin.add(mnuItemClientes);
		frmAdministrador.getContentPane().setLayout(null);
	}

	protected void mostrarClientes() {
		if (Clientes.getCounter() < 2) {
			Clientes clientes = new Clientes();
			frmAdministrador.getContentPane().add(clientes);
			clientes.setVisible(true);
			clientes.setAdmin(frmAdministrador);
		}
	}

}
