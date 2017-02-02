package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class JInicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtServer;
	private JTextField txtUser;
	private JLabel lblUser;
	private JLabel lblKey;
	private JTextField txtKey;
    private PersistenceMechanismRDBMS minhaInstancia;
	//...

    public PersistenceMechanismRDBMS getMinhaInstancia(String server, String user, String key) {
		try {
			minhaInstancia = PersistenceMechanismRDBMS.getInstance(server, user, key);
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		return minhaInstancia;
		
	}
    
	public PersistenceMechanismRDBMS getMinhaInstancia() {
		try {
			minhaInstancia = PersistenceMechanismRDBMS.getInstance();
			
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		//minhaInstancia.setServer("jdbc:mysql://localhost:3306/programa");
		return minhaInstancia;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInicio frame = new JInicio();
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
	public JInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrograma = new JButton("Programa");
		btnPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPrograma programa = new JPrograma();
				programa.setVisible(true);
				//setVisible(false);//Apenas deixa a tela invisível
				dispose();//caso não precise voltar para tela
				
			}
		});
		btnPrograma.setBounds(335, 227, 89, 23);
		contentPane.add(btnPrograma);
		
		txtServer = new JTextField();
		txtServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server;
			    String user;
			    String key;
				server = txtServer.getText();
			}
		});
		txtServer.setBounds(166, 55, 86, 20);
		contentPane.add(txtServer);
		txtServer.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(166, 86, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblServer = new JLabel("server");
		lblServer.setBounds(103, 58, 46, 14);
		contentPane.add(lblServer);
		
		lblUser = new JLabel("user");
		lblUser.setBounds(103, 89, 46, 14);
		contentPane.add(lblUser);
		
		lblKey = new JLabel("key");
		lblKey.setBounds(103, 114, 46, 14);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(166, 117, 86, 20);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
	}
}
