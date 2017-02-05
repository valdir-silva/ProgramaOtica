package interfaceGrafica;


import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JClienteRemover extends JPanel {
	private static final long serialVersionUID = 1L;
	private static String server;
	private static String user;
	private static String key;
	private JTextField textField;
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
		
		textField = new JTextField();
		textField.setBounds(66, 92, 86, 20);
		panelClienteRemover.add(textField);
		textField.setColumns(10);
	}
}
