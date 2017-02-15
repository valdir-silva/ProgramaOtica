package interfaceGrafica;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Produto;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JProdutoInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JProdutoInserir instance;
	private JTextField textFieldNome;
	private JTextField textFieldMarca;
	private JTextField textFieldValorCompra;
	private JTextField textFieldValorVenda;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Produto produto = new Produto();
	Fachada fachada;
	private JTextField textFieldQuantidade;
	//..

	
	public static JProdutoInserir getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JProdutoInserir(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JProdutoInserir(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelProdutoInserir, null);
		panelProdutoInserir.setLayout(null);
		
		JLabel lblInserir = new JLabel("Inserir");
		lblInserir.setBounds(334, 0, 61, 14);
		panelProdutoInserir.add(lblInserir);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(11, 64, 46, 14);
		panelProdutoInserir.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(56, 64, 148, 20);
		panelProdutoInserir.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblMarca = new JLabel("marca");
		lblMarca.setBounds(10, 103, 47, 14);
		panelProdutoInserir.add(lblMarca);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(56, 103, 135, 20);
		panelProdutoInserir.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel lblValorCompra = new JLabel("Valor Compra");
		lblValorCompra.setBounds(10, 143, 77, 14);
		panelProdutoInserir.add(lblValorCompra);
		
		textFieldValorCompra = new JTextField();
		textFieldValorCompra.setColumns(10);
		panelProdutoInserir.add(textFieldValorCompra);
		textFieldValorCompra.setBounds(84, 140, 97, 20);
		
		JLabel lblValorVenda = new JLabel("Valor Venda");
		lblValorVenda.setBounds(10, 182, 77, 14);
		panelProdutoInserir.add(lblValorVenda);
		
		textFieldValorVenda = new JTextField();
		textFieldValorVenda.setBounds(85, 176, 96, 20);
		panelProdutoInserir.add(textFieldValorVenda);
		textFieldValorVenda.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(11, 223, 76, 14);
		panelProdutoInserir.add(lblQuantidade);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(95, 220, 86, 20);
		panelProdutoInserir.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JButton btnInserirProduto = new JButton("Inserir Produto");
		btnInserirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fachada = Fachada.getInstance(server, user, key);
				try {
					produto.setNome(textFieldNome.getText());
					produto.setMarca(textFieldMarca.getText());
					produto.setValorCompra(Float.parseFloat(textFieldValorCompra.getText()));
					produto.setValorVenda(Float.parseFloat(textFieldValorVenda.getText()));
					produto.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
					fachada.inserir(produto);
				} catch (SemPosicaoParaInserirException | RepositorioJaExisteException | TamanhoException | RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnInserirProduto.setBounds(355, 257, 131, 23);
		panelProdutoInserir.add(btnInserirProduto);
				
	}

}
