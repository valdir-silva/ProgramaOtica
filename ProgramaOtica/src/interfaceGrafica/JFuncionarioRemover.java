package interfaceGrafica;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import exceptions.CampoVazioException;
import exceptions.RepositorioException;
import programa.Fachada;

public class JFuncionarioRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFuncionarioRemover instance;
	private static String server;
	private static String user;
	private static String key;
	private JTextField textFieldId;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFuncionarioRemover frame = new JFuncionarioRemover(server, user, key);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static JFuncionarioRemover getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JFuncionarioRemover(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JFuncionarioRemover(String server, String user, String key) {
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
						
		JPanel panelFuncionarioRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelFuncionarioRemover, null);
		panelFuncionarioRemover.setLayout(null);
		
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setBounds(336, 5, 68, 14);
		panelFuncionarioRemover.add(lblRemover);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(44, 95, 32, 14);
		panelFuncionarioRemover.add(lblId);

		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setBounds(44, 95, 46, 14);
		panelFuncionarioRemover.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(84, 92, 68, 20);
		panelFuncionarioRemover.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textFieldId.getText() != null) {
						int id=0;
						
						id = Integer.parseInt(textFieldId.getText());
						
							Fachada fachada = Fachada.getInstance(server, user, key);
						
							fachada.removerFuncionario(id);
					}else {
						throw new CampoVazioException();
					}
				} catch (RepositorioException | CampoVazioException e) {
					e.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(162, 91, 89, 23);
		panelFuncionarioRemover.add(btnRemover);
	}
	
}
