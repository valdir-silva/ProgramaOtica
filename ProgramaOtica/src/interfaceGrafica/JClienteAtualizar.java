package interfaceGrafica;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Cliente;
import base.Endereco;
import exceptions.CampoVazioException;
import exceptions.IdNaoExisteException;
import exceptions.RepositorioException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JClienteAtualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JClienteAtualizar instance;
	private JTextField textFieldNome;
	private JTextField textFieldNascimento;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JTextField textFieldCep;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldRua;
	private JTextField txtId;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	private Fachada fachada;
	//..
	
	public static JClienteAtualizar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JClienteAtualizar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JClienteAtualizar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelClienteAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelClienteAtualizar, null);
		panelClienteAtualizar.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(334, 0, 61, 14);
		panelClienteAtualizar.add(lblAtualizar);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(10, 66, 47, 14);
		panelClienteAtualizar.add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("data de nascimento");
		lblDataDeNascimento.setBounds(257, 66, 122, 14);
		panelClienteAtualizar.add(lblDataDeNascimento);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(46, 63, 201, 20);
		panelClienteAtualizar.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldNascimento = new JTextField();
		textFieldNascimento.setBounds(375, 63, 111, 20);
		panelClienteAtualizar.add(textFieldNascimento);
		textFieldNascimento.setColumns(10);
		
		JLabel lblCpf = new JLabel("cpf");
		lblCpf.setBounds(10, 106, 26, 14);
		panelClienteAtualizar.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(35, 103, 97, 20);
		panelClienteAtualizar.add(textFieldCpf);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setBounds(164, 109, 51, 14);
		panelClienteAtualizar.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(214, 106, 86, 20);
		panelClienteAtualizar.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCep = new JLabel("cep");
		lblCep.setBounds(10, 141, 33, 14);
		panelClienteAtualizar.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(40, 138, 92, 20);
		panelClienteAtualizar.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblEstado = new JLabel("estado");
		lblEstado.setBounds(160, 141, 55, 14);
		panelClienteAtualizar.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(214, 138, 101, 20);
		panelClienteAtualizar.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblCidade = new JLabel("cidade");
		lblCidade.setBounds(10, 178, 47, 14);
		panelClienteAtualizar.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(46, 175, 86, 20);
		panelClienteAtualizar.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblRua = new JLabel("rua");
		lblRua.setBounds(146, 178, 33, 14);
		panelClienteAtualizar.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(189, 175, 162, 20);
		panelClienteAtualizar.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JButton btnAtualizarCliente = new JButton("Atualizar Cliente");
		btnAtualizarCliente.addActionListener(new ActionListener() {
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
					fachada.atualizar(cliente);
				} catch (TamanhoException | RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnAtualizarCliente.setBounds(355, 257, 131, 23);
		panelClienteAtualizar.add(btnAtualizarCliente);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 29, 26, 14);
		panelClienteAtualizar.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(46, 26, 86, 20);
		panelClienteAtualizar.add(txtId);
		txtId.setColumns(10);
		
		JButton btnCarregar = new JButton("carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=0;
				id = Integer.parseInt(txtId.getText());
				if(txtId.getText() != null) {
					fachada = Fachada.getInstance(server, user, key);
					try {
						cliente = fachada.procurarCliente(id);
					} catch (NullPointerException | RepositorioException | TamanhoException e) {
						e.printStackTrace();
					} catch (IdNaoExisteException e) {
						e.printStackTrace();
					}
					//busca no banco e preenche todos os campos
					textFieldNome.setText(cliente.getNome());
					textFieldNascimento.setText(cliente.getNascimento());
					textFieldCpf.setText(cliente.getCpf());
					textFieldTelefone.setText(cliente.getTelefone());
					textFieldCep.setText(cliente.getEndereco().getCep());
					textFieldEstado.setText(cliente.getEndereco().getEstado());
					textFieldCidade.setText(cliente.getEndereco().getCidade());
					textFieldRua.setText(cliente.getEndereco().getRua());
				} else {
					try {
						throw new CampoVazioException();
					} catch (CampoVazioException e) {
						
						e.printStackTrace();
					}
				}
			}
		});
		btnCarregar.setBounds(139, 25, 89, 23);
		panelClienteAtualizar.add(btnCarregar);
		
	}
}
