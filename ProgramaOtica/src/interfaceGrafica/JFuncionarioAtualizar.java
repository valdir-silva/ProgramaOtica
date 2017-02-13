package interfaceGrafica;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Funcionario;
import exceptions.IdNaoExisteException;
import exceptions.RepositorioException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JFuncionarioAtualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFuncionarioAtualizar instance;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JTextField txtId;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Funcionario funcionario = new Funcionario();
	Fachada fachada;
	//..
	
	public static JFuncionarioAtualizar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JFuncionarioAtualizar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JFuncionarioAtualizar(String server, String user, String key) {
setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelFuncionarioAtualizar, null);
		panelFuncionarioAtualizar.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(334, 0, 61, 14);
		panelFuncionarioAtualizar.add(lblAtualizar);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(10, 66, 47, 14);
		panelFuncionarioAtualizar.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(46, 63, 201, 20);
		panelFuncionarioAtualizar.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblCpf = new JLabel("cpf");
		lblCpf.setBounds(10, 106, 26, 14);
		panelFuncionarioAtualizar.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(35, 103, 97, 20);
		panelFuncionarioAtualizar.add(textFieldCpf);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setBounds(164, 109, 51, 14);
		panelFuncionarioAtualizar.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(214, 106, 86, 20);
		panelFuncionarioAtualizar.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		
		JButton btnAtualizarFuncionario = new JButton("Atualizar Funcionario");
		btnAtualizarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*(teste) estou testando sem a instance pq aparentemente é redundante
				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();
				Fachada instance = Fachada.getInstance(server, user, key);
				Fachada fachada = instance;
				*/
				fachada = Fachada.getInstance(server, user, key);
				try {
					funcionario.setNome(textFieldNome.getText());
					funcionario.setCpf(textFieldCpf.getText());
					funcionario.setTelefone(textFieldTelefone.getText());
					fachada.atualizar(funcionario);
				} catch (TamanhoException | RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnAtualizarFuncionario.setBounds(355, 257, 131, 23);
		panelFuncionarioAtualizar.add(btnAtualizarFuncionario);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 29, 26, 14);
		panelFuncionarioAtualizar.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(46, 26, 86, 20);
		panelFuncionarioAtualizar.add(txtId);
		txtId.setColumns(10);
		
		JButton btnCarregar = new JButton("carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idS;
				int id = 0;
				idS = txtId.getText();
				id = Integer.parseInt(idS);
				fachada = Fachada.getInstance(server, user, key);
				try {
					funcionario = fachada.procurarFuncionario(id);
				} catch (NullPointerException | RepositorioException | TamanhoException | IdNaoExisteException e) {

					e.printStackTrace();
				}
				//busca no banco e preenche todos os campos
				textFieldNome.setText(funcionario.getNome());
				textFieldCpf.setText(funcionario.getCpf());
				textFieldTelefone.setText(funcionario.getTelefone());
			}
		});
		btnCarregar.setBounds(139, 25, 89, 23);
		panelFuncionarioAtualizar.add(btnCarregar);
	
	}

}
