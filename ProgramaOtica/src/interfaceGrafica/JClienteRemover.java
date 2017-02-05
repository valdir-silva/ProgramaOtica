package interfaceGrafica;


import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Cliente;
import exceptions.RepositorioException;
import programa.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JClienteRemover extends JPanel {
	private static final long serialVersionUID = 1L;
	private static String server;
	private static String user;
	private static String key;
	private JTextField txtId;
	
	//NAO TA USAAAANDO(server, user e key) LEMBRAR!
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JClienteRemover frame = new JClienteRemover(server, user, key);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JClienteRemover(String server, String user, String key) {
		
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
						
		JPanel panelClienteRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelClienteRemover, null);
		panelClienteRemover.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Remover");
		lblNewLabel_1.setBounds(336, 5, 68, 14);
		panelClienteRemover.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setBounds(44, 95, 46, 14);
		panelClienteRemover.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(66, 92, 86, 20);
		panelClienteRemover.add(txtId);
		txtId.setColumns(10);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idS;
				int id=0;
				idS = txtId.getText();
				id = Integer.parseInt(idS);
				Fachada instance = Fachada.getInstance(server, user, key);
				Fachada fachada = instance;
				try {
					fachada.removerCliente(id);
				} catch (RepositorioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(162, 91, 89, 23);
		panelClienteRemover.add(btnRemover);
	}
}
