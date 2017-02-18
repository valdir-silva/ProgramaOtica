package interfaceGrafica;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.ItemVenda;
import base.Produto;
import base.Venda;
import exceptions.IdNaoExisteException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JVendaAtualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaAtualizar instance;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	private JTextField txtId;
	private JTextField textFieldIdCliente;
	private JTextField textFieldData;
	private JTextField textFieldIdProduto;
	private JTextField textFieldQuantidade;
	private ItemVenda[] vendas = new ItemVenda[10];
	private int i = 0;
	
	public static JVendaAtualizar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaAtualizar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JVendaAtualizar(String server, String user, String key) {
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
		
		JLabel labelTotal = new JLabel("0");
		labelTotal.setBounds(120, 246, 54, 14);
		panelVendaAtualizar.add(labelTotal);
		
		JButton btnAtualizarVenda = new JButton("Atualizar Venda");
		btnAtualizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda.setIdCliente(Integer.parseInt(textFieldIdCliente.getText()));
					venda.setTotal(Integer.parseInt(labelTotal.getText()));
					venda.setData(textFieldData.getText());
					
					//implementar Itens Venda
					fachada.atualizar(venda);
				} catch (TamanhoException | RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnAtualizarVenda.setBounds(346, 257, 140, 23);
		panelVendaAtualizar.add(btnAtualizarVenda);
		
		JButton btnCarregar = new JButton("carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(txtId.getText());
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda = fachada.procurarVenda(id);
					textFieldIdCliente.setText(Integer.toString(venda.getIdCliente()));
					textFieldData.setText(venda.getData());
					labelTotal.setText(Float.toString(venda.getTotal()));
					
					vendas = venda.getVendas();
				} catch (NullPointerException | RepositorioException | TamanhoException | IdNaoExisteException e) {

					e.printStackTrace();
				}
			}
		});
		btnCarregar.setBounds(139, 25, 89, 23);
		panelVendaAtualizar.add(btnCarregar);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 28, 26, 14);
		panelVendaAtualizar.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(46, 25, 86, 20);
		panelVendaAtualizar.add(txtId);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(11, 63, 70, 14);
		panelVendaAtualizar.add(lblIdCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBounds(120, 63, 100, 20);
		panelVendaAtualizar.add(textFieldIdCliente);
		
		JLabel lblData = new JLabel("Data da venda");
		lblData.setBounds(10, 94, 86, 14);
		panelVendaAtualizar.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		textFieldData.setBounds(119, 94, 86, 20);
		panelVendaAtualizar.add(textFieldData);
		
		JLabel lblTotal = new JLabel("Total comprado");
		lblTotal.setBounds(11, 246, 99, 14);
		panelVendaAtualizar.add(lblTotal);
		
		textFieldIdProduto = new JTextField();
		textFieldIdProduto.setColumns(10);
		textFieldIdProduto.setBounds(400, 63, 86, 20);
		panelVendaAtualizar.add(textFieldIdProduto);
		
		JLabel labelIdProduto = new JLabel("Id do Produto");
		labelIdProduto.setBounds(312, 69, 78, 14);
		panelVendaAtualizar.add(labelIdProduto);
		
		JLabel label_1 = new JLabel("Quantidade");
		label_1.setBounds(312, 112, 78, 14);
		panelVendaAtualizar.add(label_1);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(400, 109, 86, 20);
		panelVendaAtualizar.add(textFieldQuantidade);
		
		JButton button = new JButton("Adicionar ao Carrinho");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float total = 0;
				fachada = Fachada.getInstance(server, user, key);
				ItemVenda item = new ItemVenda();
				item.setIdProduto(Integer.parseInt(textFieldIdProduto.getText()));
				item.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				item.setIdVenda(0);
				
				total = Float.parseFloat(labelTotal.getText());
				Produto produto = new Produto();
				try {
					produto = fachada.procurarProduto(item.getIdProduto());
				
					total += item.getQuantidade() * produto.getValorVenda();//calcula o total
					
					labelTotal.setText(Float.toString(total));//coloca o valor total no text field
					vendas[i++] = item;
					
					fachada.inserir(item);
				} catch (NullPointerException | SemPosicaoParaInserirException | RepositorioException | TamanhoException
						| QuantidadeProdutoInvalidaException | IdNaoExisteException e1) {
					e1.printStackTrace();
				}
				
				
			
			}
		});
		button.setBounds(312, 150, 172, 23);
		panelVendaAtualizar.add(button);
		
		

		
	}
}
