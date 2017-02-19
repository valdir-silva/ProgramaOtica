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

public class JProdutoRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JProdutoRemover instance;
	private static String server;
	private static String user;
	private static String key;
	private JTextField textFieldId;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JProdutoRemover frame = new JProdutoRemover(server, user, key);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static JProdutoRemover getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JProdutoRemover(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JProdutoRemover(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelProdutoRemover, null);
		panelProdutoRemover.setLayout(null);
		
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setBounds(336, 5, 68, 14);
		panelProdutoRemover.add(lblRemover);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(44, 95, 46, 14);
		panelProdutoRemover.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(66, 92, 86, 20);
		panelProdutoRemover.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textFieldId.getText() != null) {
						int id=0;
						
						id = Integer.parseInt(textFieldId.getText());
						
							Fachada fachada = Fachada.getInstance(server, user, key);
						
							fachada.removerProduto(id);
					}else {
						throw new CampoVazioException();
					}
				} catch (RepositorioException | CampoVazioException e) {
					e.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(162, 91, 89, 23);
		panelProdutoRemover.add(btnRemover);
		
	}

}
