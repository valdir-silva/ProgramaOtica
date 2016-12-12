package interfaceGrafica;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
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
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBackground(new Color(204, 255, 255));
		textFieldLogin.setBounds(149, 71, 86, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setForeground(new Color(0, 0, 0));
		textFieldSenha.setBackground(new Color(204, 255, 255));
		textFieldSenha.setBounds(149, 125, 86, 20);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 14));
		lblLogin.setBounds(83, 71, 56, 17);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("senha");
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSenha.setBounds(83, 125, 56, 17);
		contentPane.add(lblSenha);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//abrir tela inicial se login estiver certo
				String login = textFieldLogin.getText();
				String senha = textFieldSenha.getText();
				String funcionarioLogin = "095";
				String funcionarioSenha = "math";
				if(login.equals(funcionarioLogin) && senha.equals(funcionarioSenha)) {
					JPrograma programa = new JPrograma();
					programa.setVisible(true);
					setVisible(false);//Apenas deixa a tela invisível
					dispose();//caso não precise voltar para tela
				}
			}
		});
		btnLogin.setBounds(149, 178, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblProgramatica = new JLabel("Programa \u00D3tica");
		lblProgramatica.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblProgramatica.setBounds(132, 11, 124, 33);
		contentPane.add(lblProgramatica);
	}
}
