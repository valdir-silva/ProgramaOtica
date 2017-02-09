package interfaceGrafica;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Cliente;
import base.Endereco;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import programa.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JClienteInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JClienteInserir instance;
	private JTextField textFieldNome;
	private JTextField textFieldNascimento;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JTextField textFieldCep;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldRua;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	private Fachada fachada;
	//..
	
	public static JClienteInserir getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JClienteInserir(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JClienteInserir(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelClienteInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelClienteInserir, null);
		panelClienteInserir.setLayout(null);
		
		JLabel lblInserir = new JLabel("Inserir");
		lblInserir.setBounds(342, 5, 46, 14);
		panelClienteInserir.add(lblInserir);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(10, 55, 46, 14);
		panelClienteInserir.add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("data de nascimento");
		lblDataDeNascimento.setBounds(252, 55, 116, 14);
		panelClienteInserir.add(lblDataDeNascimento);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(53, 52, 190, 20);
		panelClienteInserir.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldNascimento = new JTextField();
		textFieldNascimento.setBounds(368, 52, 86, 20);
		panelClienteInserir.add(textFieldNascimento);
		textFieldNascimento.setColumns(10);
		
		JLabel lblCpf = new JLabel("cpf");
		lblCpf.setBounds(10, 96, 46, 14);
		panelClienteInserir.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(41, 93, 101, 20);
		panelClienteInserir.add(textFieldCpf);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setBounds(152, 96, 46, 14);
		panelClienteInserir.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(213, 93, 86, 20);
		panelClienteInserir.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCep = new JLabel("cep");
		lblCep.setBounds(10, 135, 46, 14);
		panelClienteInserir.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(43, 132, 101, 20);
		panelClienteInserir.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblEstado = new JLabel("estado");
		lblEstado.setBounds(159, 135, 46, 14);
		panelClienteInserir.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(213, 132, 101, 20);
		panelClienteInserir.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblCidade = new JLabel("cidade");
		lblCidade.setBounds(10, 172, 46, 14);
		panelClienteInserir.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(53, 169, 86, 20);
		panelClienteInserir.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblRua = new JLabel("rua");
		lblRua.setBounds(158, 172, 25, 14);
		panelClienteInserir.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(193, 169, 153, 20);
		panelClienteInserir.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JButton btnInserirCliente = new JButton("Inserir Cliente");
		btnInserirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fachada = Fachada.getInstance(server, user, key);
				try {
					cliente.setNome(textFieldNome.getText());
					cliente.setNascimento(textFieldNascimento.getText());
					cliente.setCpf(textFieldCpf.getText());
					cliente.setTelefone(textFieldTelefone.getText());
					endereco.setCep(textFieldCep.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setRua(textFieldRua.getText());
					cliente.setEndereco(endereco);
					fachada.inserir(cliente);
				} catch (TamanhoException | SemPosicaoParaInserirException | RepositorioException | RepositorioJaExisteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInserirCliente.setBounds(353, 251, 116, 23);
		panelClienteInserir.add(btnInserirCliente);
		
	}
}
