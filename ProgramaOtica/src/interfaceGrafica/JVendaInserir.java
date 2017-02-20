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
import exceptions.CampoVazioException;
import exceptions.IdNaoExisteException;
import exceptions.QuantidadeEstoqueMenorException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import programa.Fachada;
import java.awt.Color;
import java.awt.Font;

public class JVendaInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaInserir instance;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	private JTextField textFieldIdCliente;
	private JTextField textFieldData;
	private JTextField textFieldIdProduto;
	private JTextField textFieldQuantidade;
	private ItemVenda[] vendas = new ItemVenda[10];
	private int i = 0;
	
	
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
		
		JLabel labelTotal = new JLabel("0");
		labelTotal.setFont(new Font("Raavi", Font.BOLD, 11));
		labelTotal.setForeground(Color.BLACK);
		labelTotal.setBounds(120, 234, 46, 14);
		panelVendaInserir.add(labelTotal);
		
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fachada = Fachada.getInstance(server, user, key);
				try {
					if(textFieldIdCliente.getText() != null && textFieldData.getText() != null) {
							venda.setIdCliente(Integer.parseInt(textFieldIdCliente.getText()));
							venda.setTotal(Float.parseFloat(labelTotal.getText()));
							venda.setData(textFieldData.getText());
							
							venda.setVendas(vendas);
							
							fachada.inserir(venda);
					}else {
						throw new CampoVazioException();
					}
				} catch (TamanhoException | RepositorioException | NullPointerException | SemPosicaoParaInserirException | QuantidadeProdutoInvalidaException | CampoVazioException e) {
					e.printStackTrace();
				}
			}
		});
		btnRealizarVenda.setBounds(358, 273, 142, 23);
		panelVendaInserir.add(btnRealizarVenda);
		
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
		
		JLabel lblTotal = new JLabel("Total comprado");
		lblTotal.setBounds(11, 232, 99, 14);
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
				float total = 0;
				fachada = Fachada.getInstance(server, user, key);
				ItemVenda item = new ItemVenda();
				
				item.setIdProduto(Integer.parseInt(textFieldIdProduto.getText()));
				item.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				
				total = Float.parseFloat(labelTotal.getText());
				Produto produto = new Produto();
				try {
					produto = fachada.procurarProduto(item.getIdProduto());
				
					if(produto != null) {//se produto existir
						//se nao existir itens suficientes no estoque
						if((produto.getQuantidade() - item.getQuantidade()) > 0 ) {
							total += item.getQuantidade() * produto.getValorVenda();//calcula o total
							
							labelTotal.setText(Float.toString(total));//coloca o valor total no text field
							
							//tenho que pegar o id de item venda, antes de enviar para venda
							vendas[i++] = item;
						}else
							throw new QuantidadeEstoqueMenorException();
					}
				} catch (NullPointerException | RepositorioException | TamanhoException
					 | IdNaoExisteException | QuantidadeEstoqueMenorException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnAdicionar.setBounds(334, 164, 172, 23);
		panelVendaInserir.add(btnAdicionar);
		
		
		

		
	}
}
