package interfaceGrafica;

import java.awt.BorderLayout;
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
import javax.swing.JDesktopPane;

public class JLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtText;

	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 720, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 255, 255));
		textField.setBounds(149, 71, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtText = new JTextField();
		txtText.setForeground(new Color(0, 0, 0));
		txtText.setBackground(new Color(204, 255, 255));
		txtText.setBounds(149, 125, 86, 20);
		contentPane.add(txtText);
		txtText.setColumns(10);
		
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
				JPrograma programa = new JPrograma();
				contentPane.add(programa);
				programa.setVisible(true);
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
