package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Venda;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JVendaInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaInserir instance;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	private JTextField txtId;
	private JTextField textFieldIdCliente;
	private JTextField textFieldData;
	private JTextField textFieldTotal;
	private JTextField textFieldIdProduto;
	private JTextField textFieldQuantidade;
	
	public static JVendaInserir getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaInserir(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JVendaInserir(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelVendaInserir, null);
		panelVendaInserir.setLayout(null);
		
		JLabel lblInserir = new JLabel("Inserir");
		lblInserir.setBounds(334, 0, 61, 14);
		panelVendaInserir.add(lblInserir);
		
		
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda.setIdCliente(Integer.parseInt(textFieldIdCliente.getText()));
					venda.setTotal(Float.parseFloat(textFieldTotal.getText()));
					venda.setData(textFieldData.getText());
					
					fachada.inserir(venda);
				} catch (TamanhoException | RepositorioException | NullPointerException | SemPosicaoParaInserirException | QuantidadeProdutoInvalidaException e) {
					e.printStackTrace();
				}
			}
		});
		btnRealizarVenda.setBounds(369, 273, 131, 23);
		panelVendaInserir.add(btnRealizarVenda);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 14, 26, 14);
		panelVendaInserir.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(46, 11, 86, 20);
		panelVendaInserir.add(txtId);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(11, 49, 70, 14);
		panelVendaInserir.add(lblIdCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBounds(120, 49, 100, 20);
		panelVendaInserir.add(textFieldIdCliente);
		
		JLabel lblData = new JLabel("Data da venda");
		lblData.setBounds(10, 80, 86, 14);
		panelVendaInserir.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		textFieldData.setBounds(119, 80, 86, 20);
		panelVendaInserir.add(textFieldData);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(120, 229, 86, 20);
		panelVendaInserir.add(textFieldTotal);
		
		JLabel lblTotal = new JLabel("Total comprado");
		lblTotal.setBounds(11, 232, 86, 14);
		panelVendaInserir.add(lblTotal);
		
		JLabel lblIdProduto = new JLabel("Id do Produto");
		lblIdProduto.setBounds(334, 83, 78, 14);
		panelVendaInserir.add(lblIdProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(334, 126, 78, 14);
		panelVendaInserir.add(lblQuantidade);
		
		textFieldIdProduto = new JTextField();
		textFieldIdProduto.setBounds(422, 77, 86, 20);
		panelVendaInserir.add(textFieldIdProduto);
		textFieldIdProduto.setColumns(10);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(422, 123, 86, 20);
		panelVendaInserir.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar ao Carrinho");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnAdicionar.setBounds(355, 164, 151, 23);
		panelVendaInserir.add(btnAdicionar);
		
	}
}
