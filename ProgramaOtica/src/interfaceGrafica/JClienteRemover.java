package interfaceGrafica;


import javax.swing.JLabel;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import exceptions.RepositorioException;
import programa.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class JClienteRemover extends JPanel {
	private static final long serialVersionUID = 1L;
	private static JClienteRemover instance;
	private static String server;
	private static String user;
	private static String key;
	private JTextField textFieldId;
	
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


	public static JClienteRemover getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JClienteRemover(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}
	
	private JClienteRemover(String server, String user, String key) {
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
						
		JPanel panelClienteRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelClienteRemover, null);
		panelClienteRemover.setLayout(null);
		
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setBounds(336, 5, 68, 14);
		panelClienteRemover.add(lblRemover);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(44, 95, 32, 14);
		panelClienteRemover.add(lblId);

		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setBounds(44, 95, 46, 14);
		panelClienteRemover.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(84, 92, 68, 20);
		panelClienteRemover.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=0;
				
				id = Integer.parseInt(textFieldId.getText());
				try {
					Fachada fachada = Fachada.getInstance(server, user, key);
				
					fachada.removerCliente(id);
				} catch (RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(162, 91, 89, 23);
		panelClienteRemover.add(btnRemover);
		
	}
}
