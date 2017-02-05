package interfaceGrafica;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class JInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServer;
	private JTextField txtUser;
	private JLabel lblUser;
	private JLabel lblKey;
	private JTextField txtKey;
    private PersistenceMechanismRDBMS minhaInstancia;
    public String key; //variavel publica para trasmitir dados do server para o metodo getMinhaInstancia
    public String server;
    public String user;


	public PersistenceMechanismRDBMS getMinhaInstancia(String server, String user, String key) {
		try {
			System.out.println("minha instancia" + this.server + server);
			minhaInstancia = PersistenceMechanismRDBMS.getInstance(server, user, key);
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		return minhaInstancia;
		
	}
    
	public PersistenceMechanismRDBMS getMinhaInstancia() {
		try {
			minhaInstancia = PersistenceMechanismRDBMS.getInstance();
			//minhaInstancia.setUrl(teste);
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
				if(txtServer.getText().equals("")){
					server = "jdbc:mysql://localhost:3306/programa";
					user = "root";
					key="";
				}
				else{
					server = txtServer.getText();
					user = txtUser.getText();
					key = txtKey.getText();			
				}
				
				JPrograma programa = new JPrograma(server, user, key);
				programa.setVisible(true);
				setVisible(false);//Apenas deixa a tela invisível
				dispose();//caso não precise voltar para tela
				
			}
		});
		btnPrograma.setBounds(312, 227, 112, 23);
		contentPane.add(btnPrograma);
		
		txtServer = new JTextField();
		txtServer.setBounds(143, 90, 201, 20);
		contentPane.add(txtServer);
		txtServer.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(143, 121, 201, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblServer = new JLabel("server");
		lblServer.setBounds(80, 93, 46, 14);
		contentPane.add(lblServer);
		
		lblUser = new JLabel("user");
		lblUser.setBounds(80, 124, 46, 14);
		contentPane.add(lblUser);
		
		lblKey = new JLabel("key");
		lblKey.setBounds(80, 149, 46, 14);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(143, 152, 201, 20);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		JLabel lbldeixeEmBranco = new JLabel("*Deixe em branco para localhost");
		lbldeixeEmBranco.setForeground(Color.LIGHT_GRAY);
		lbldeixeEmBranco.setBounds(10, 236, 201, 14);
		contentPane.add(lbldeixeEmBranco);
		
		JButton btnWhiteofdarkcom = new JButton("whiteofdark.com");
		btnWhiteofdarkcom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtServer.setText("jdbc:mysql://whiteofdark.com:3306/whiteofd_programa");
				txtUser.setText("whiteofd_ark");
				txtKey.setText("1!2@3#");
			}
		});
		btnWhiteofdarkcom.setBounds(54, 11, 139, 23);
		contentPane.add(btnWhiteofdarkcom);
		
		JLabel lblNvem = new JLabel("N\u00FAvem:");
		lblNvem.setBounds(10, 15, 46, 14);
		contentPane.add(lblNvem);
	}
}
