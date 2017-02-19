package interfaceGrafica;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Funcionario;
import exceptions.CampoVazioException;
import exceptions.IdNaoExisteException;
import exceptions.RepositorioException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JFuncionarioProcurar extends JPanel {
	private static final long serialVersionUID = 1L;
	private static JFuncionarioProcurar instance;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JTextField txtId;
	//declara��o de objetos aqui para ser poss�vel usar nos dois m�todos (carregar e atualizar)
	Funcionario funcionario = new Funcionario();
	Fachada fachada;
	//..
	
	public static JFuncionarioProcurar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JFuncionarioProcurar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JFuncionarioProcurar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioProcurar = new JPanel();
		tabbedPane.addTab("Procurar", null, panelFuncionarioProcurar, null);
		panelFuncionarioProcurar.setLayout(null);
		
		JLabel lblProcurar = new JLabel("Procurar");
		lblProcurar.setBounds(334, 0, 61, 14);
		panelFuncionarioProcurar.add(lblProcurar);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(10, 66, 47, 14);
		panelFuncionarioProcurar.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(46, 63, 201, 20);
		panelFuncionarioProcurar.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblCpf = new JLabel("cpf");
		lblCpf.setBounds(10, 106, 26, 14);
		panelFuncionarioProcurar.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(35, 103, 97, 20);
		panelFuncionarioProcurar.add(textFieldCpf);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setBounds(164, 109, 51, 14);
		panelFuncionarioProcurar.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(214, 106, 86, 20);
		panelFuncionarioProcurar.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
				
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 29, 26, 14);
		panelFuncionarioProcurar.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(46, 26, 86, 20);
		panelFuncionarioProcurar.add(txtId);
		txtId.setColumns(10);
		
		JButton btnCarregar = new JButton("Procurar Funcionario");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(txtId.getText() != null) {
						int id = Integer.parseInt(txtId.getText());
						
						fachada = Fachada.getInstance(server, user, key);
						
							funcionario = fachada.procurarFuncionario(id);
						//busca no banco e preenche todos os campos
						textFieldNome.setText(funcionario.getNome());
						textFieldCpf.setText(funcionario.getCpf());
						textFieldTelefone.setText(funcionario.getTelefone());
					}else {
						throw new CampoVazioException();
					}
				}
				catch (NullPointerException | RepositorioException | TamanhoException | IdNaoExisteException | CampoVazioException e) {
					e.printStackTrace();
				}
					
			}
		});
		btnCarregar.setBounds(139, 25, 89, 23);
		panelFuncionarioProcurar.add(btnCarregar);
	
	}

}
