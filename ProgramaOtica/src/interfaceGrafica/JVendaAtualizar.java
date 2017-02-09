package interfaceGrafica;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Venda;
import exceptions.RepositorioException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JVendaAtualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaAtualizar instance;
	private JTextField textFieldIdCliente;
	private JTextField textFieldIdProduto;
	private JTextField txtId;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	
	public static JVendaAtualizar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaAtualizar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaAtualizar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelVendaAtualizar, null);
		panelVendaAtualizar.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(334, 0, 61, 14);
		panelVendaAtualizar.add(lblAtualizar);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(11, 64, 70, 14);
		panelVendaAtualizar.add(lblIdCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setBounds(91, 64, 148, 20);
		panelVendaAtualizar.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JLabel lblIdProduto = new JLabel("Id Produto");
		lblIdProduto.setBounds(10, 103, 71, 14);
		panelVendaAtualizar.add(lblIdProduto);
		
		textFieldIdProduto = new JTextField();
		textFieldIdProduto.setBounds(91, 103, 148, 20);
		panelVendaAtualizar.add(textFieldIdProduto);
		textFieldIdProduto.setColumns(10);
		
		
		JButton btnAtualizarVenda = new JButton("Atualizar Venda");
		btnAtualizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*(teste) estou testando sem a instance pq aparentemente é redundante
				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();
				Fachada instance = Fachada.getInstance(server, user, key);
				Fachada fachada = instance;
				*/
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda.setCliente(Integer.parseInt(textFieldIdCliente.getText()));
					venda.setProduto(Integer.parseInt(textFieldIdProduto.getText()));
					fachada.atualizar(venda);
				} catch (TamanhoException | RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnAtualizarVenda.setBounds(355, 257, 131, 23);
		panelVendaAtualizar.add(btnAtualizarVenda);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 29, 26, 14);
		panelVendaAtualizar.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(46, 26, 86, 20);
		panelVendaAtualizar.add(txtId);
		txtId.setColumns(10);
		
		JButton btnCarregar = new JButton("carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = 0;
				id = Integer.parseInt(txtId.getText());
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda = fachada.procurarVenda(id);
				} catch (NullPointerException | RepositorioException | TamanhoException e) {

					e.printStackTrace();
				}
				//busca no banco e preenche todos os campos
				textFieldIdCliente.setText(Integer.toString(venda.getCliente()));
				textFieldIdProduto.setText(Integer.toString(venda.getProduto()));
			}
		});
		btnCarregar.setBounds(139, 25, 89, 23);
		panelVendaAtualizar.add(btnCarregar);

		
	}
}
