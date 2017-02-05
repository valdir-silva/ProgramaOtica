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
	Cliente cliente = new Cliente();
	Endereco endereco = new Endereco();
	Fachada fachada;
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

	public JClienteAtualizar(String server, String user, String key) {
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
		lblNome.setBounds(10, 57, 47, 14);
		panelClienteAtualizar.add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("data de nascimento");
		lblDataDeNascimento.setBounds(257, 57, 122, 14);
		panelClienteAtualizar.add(lblDataDeNascimento);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(46, 54, 201, 20);
		panelClienteAtualizar.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldNascimento = new JTextField();
		textFieldNascimento.setBounds(375, 54, 111, 20);
		panelClienteAtualizar.add(textFieldNascimento);
		textFieldNascimento.setColumns(10);
		
		JLabel lblCpf = new JLabel("cpf");
		lblCpf.setBounds(10, 97, 26, 14);
		panelClienteAtualizar.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(35, 94, 97, 20);
		panelClienteAtualizar.add(textFieldCpf);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setBounds(164, 100, 51, 14);
		panelClienteAtualizar.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(214, 97, 86, 20);
		panelClienteAtualizar.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCep = new JLabel("cep");
		lblCep.setBounds(10, 132, 33, 14);
		panelClienteAtualizar.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(40, 129, 92, 20);
		panelClienteAtualizar.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblEstado = new JLabel("estado");
		lblEstado.setBounds(160, 132, 55, 14);
		panelClienteAtualizar.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(214, 129, 101, 20);
		panelClienteAtualizar.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblCidade = new JLabel("cidade");
		lblCidade.setBounds(10, 169, 47, 14);
		panelClienteAtualizar.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(46, 166, 86, 20);
		panelClienteAtualizar.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblRua = new JLabel("rua");
		lblRua.setBounds(146, 169, 33, 14);
		panelClienteAtualizar.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(189, 166, 162, 20);
		panelClienteAtualizar.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JButton btnAtualizarCliente = new JButton("Atualizar Cliente");
		btnAtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*(teste) estou testando sem a instance pq aparentemente é redundante
				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();
				Fachada instance = Fachada.getInstance(server, user, key);
				Fachada fachada = instance;
				*/
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAtualizarCliente.setBounds(355, 248, 131, 23);
		panelClienteAtualizar.add(btnAtualizarCliente);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 32, 26, 14);
		panelClienteAtualizar.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(46, 29, 86, 20);
		panelClienteAtualizar.add(txtId);
		txtId.setColumns(10);
		
		JButton btnCarregar = new JButton("carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idS;
				int id=0;
				idS = txtId.getText();
				id = Integer.parseInt(idS);
				try {
					cliente = fachada.procurarCliente(id);
				} catch (NullPointerException | RepositorioException | TamanhoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//fazer essa parte buscar no banco e preencher todos os campos
				textFieldNome.setText(cliente.getNome());
				textFieldNascimento.setText(cliente.getNascimento());
			}
		});
		btnCarregar.setBounds(139, 28, 89, 23);
		panelClienteAtualizar.add(btnCarregar);
		
	}
}
