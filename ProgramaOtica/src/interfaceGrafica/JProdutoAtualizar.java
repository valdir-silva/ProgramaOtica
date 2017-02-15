package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Produto;
import exceptions.IdNaoExisteException;
import exceptions.RepositorioException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JProdutoAtualizar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JProdutoAtualizar instance;
	private JTextField textFieldNome;
	private JTextField textFieldMarca;
	private JTextField textFieldValorCompra;
	private JTextField textFieldValorVenda;
	private JTextField txtId;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Produto produto = new Produto();
	Fachada fachada;
	private JTextField textFieldQuantidade;
	//..
	
	public static JProdutoAtualizar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JProdutoAtualizar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JProdutoAtualizar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelProdutoAtualizar, null);
		panelProdutoAtualizar.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(334, 0, 61, 14);
		panelProdutoAtualizar.add(lblAtualizar);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(11, 64, 46, 14);
		panelProdutoAtualizar.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(56, 64, 148, 20);
		panelProdutoAtualizar.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblMarca = new JLabel("marca");
		lblMarca.setBounds(10, 103, 47, 14);
		panelProdutoAtualizar.add(lblMarca);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(56, 103, 135, 20);
		panelProdutoAtualizar.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel lblValorCompra = new JLabel("Valor Compra");
		lblValorCompra.setBounds(10, 143, 77, 14);
		panelProdutoAtualizar.add(lblValorCompra);
		
		textFieldValorCompra = new JTextField();
		textFieldValorCompra.setColumns(10);
		panelProdutoAtualizar.add(textFieldValorCompra);
		textFieldValorCompra.setBounds(84, 140, 97, 20);
		
		JLabel lblValorVenda = new JLabel("Valor Venda");
		lblValorVenda.setBounds(10, 182, 77, 14);
		panelProdutoAtualizar.add(lblValorVenda);
		
		textFieldValorVenda = new JTextField();
		textFieldValorVenda.setBounds(85, 176, 96, 20);
		panelProdutoAtualizar.add(textFieldValorVenda);
		textFieldValorVenda.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(11, 220, 76, 14);
		panelProdutoAtualizar.add(lblQuantidade);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(95, 217, 86, 20);
		panelProdutoAtualizar.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		
		JButton btnAtualizarProduto = new JButton("Atualizar Produto");
		btnAtualizarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*(teste) estou testando sem a instance pq aparentemente é redundante
				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();
				Fachada instance = Fachada.getInstance(server, user, key);
				Fachada fachada = instance;
				*/
				fachada = Fachada.getInstance(server, user, key);
				try {
					produto.setNome(textFieldNome.getText());
					produto.setMarca(textFieldMarca.getText());
					produto.setValorCompra(Float.parseFloat(textFieldValorCompra.getText()));
					produto.setValorVenda(Float.parseFloat(textFieldValorVenda.getText()));
					produto.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
					
					fachada.atualizar(produto);
				} catch (TamanhoException | RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnAtualizarProduto.setBounds(355, 257, 131, 23);
		panelProdutoAtualizar.add(btnAtualizarProduto);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 29, 26, 14);
		panelProdutoAtualizar.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(46, 26, 86, 20);
		panelProdutoAtualizar.add(txtId);
		txtId.setColumns(10);
		
		JButton btnCarregar = new JButton("carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = 0;
				id = Integer.parseInt(txtId.getText());
				fachada = Fachada.getInstance(server, user, key);
				try {
					produto = fachada.procurarProduto(id);
				} catch (NullPointerException | RepositorioException | TamanhoException | IdNaoExisteException e) {

					e.printStackTrace();
				}
				//busca no banco e preenche todos os campos
				textFieldNome.setText(produto.getNome());
				textFieldMarca.setText(produto.getMarca());
				textFieldValorCompra.setText(Float.toString(produto.getValorCompra()));
				textFieldValorVenda.setText(Float.toString(produto.getValorVenda()));
				textFieldQuantidade.setText(Integer.toString(produto.getQuantidade()));
			}
		});
		btnCarregar.setBounds(139, 25, 89, 23);
		panelProdutoAtualizar.add(btnCarregar);
		
	}
}
