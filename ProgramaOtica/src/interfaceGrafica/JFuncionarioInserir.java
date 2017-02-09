package interfaceGrafica;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Funcionario;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JFuncionarioInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFuncionarioInserir instance;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	
	public static JFuncionarioInserir getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JFuncionarioInserir(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JFuncionarioInserir(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelFuncionarioInserir, null);
		panelFuncionarioInserir.setLayout(null);
		
		JLabel lblInserir = new JLabel("Inserir");
		lblInserir.setBounds(342, 5, 46, 14);
		panelFuncionarioInserir.add(lblInserir);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(10, 55, 46, 14);
		panelFuncionarioInserir.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(53, 52, 190, 20);
		panelFuncionarioInserir.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("cpf");
		lblCpf.setBounds(10, 96, 46, 14);
		panelFuncionarioInserir.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(41, 93, 101, 20);
		panelFuncionarioInserir.add(textFieldCpf);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setBounds(152, 96, 46, 14);
		panelFuncionarioInserir.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(213, 93, 86, 20);
		panelFuncionarioInserir.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JButton btnInserirFuncionario = new JButton("Inserir Funcionario");
		btnInserirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario funcionario = new Funcionario();
				Fachada instance = Fachada.getInstance(server, user, key);
				Fachada fachada = instance;
				try {
					funcionario.setNome(textFieldNome.getText());
					funcionario.setCpf(textFieldCpf.getText());
					funcionario.setTelefone(textFieldTelefone.getText());
					fachada.inserir(funcionario);
				} catch (TamanhoException | SemPosicaoParaInserirException | RepositorioException | RepositorioJaExisteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInserirFuncionario.setBounds(353, 251, 116, 23);
		panelFuncionarioInserir.add(btnInserirFuncionario);
	}
}
