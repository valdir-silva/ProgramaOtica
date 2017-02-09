package interfaceGrafica;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioProdutoArray;

public class JProdutoTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public JProdutoTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelJProdutoTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelJProdutoTodos, null);
		
				///////////
				//Tabela///
				///////////
				String [] colunas = {"id", "Nome", "Marca", "ValorCompra", "ValorVenda"};
				String [][] dados = null;
				
				RepositorioProdutoArray produtos = new RepositorioProdutoArray();
		
				Fachada instance = Fachada.getInstance(server, user, key);
				Fachada fachada = instance;
				
				try {
					produtos = fachada.todosProdutos();
					dados = produtos.todosProdutos();
				} catch (TamanhoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
				panelJProdutoTodos.setLayout(null);
				
				table = new JTable(dados, colunas);
				table.setBounds(0, 0, 680, 528);
				
				panelJProdutoTodos.add(table);		
		

		
		tabbedPane.addTab("Inserir", new JProdutoInserir(server, user, key));
		
		tabbedPane.addTab("Atualizar", new JProdutoAtualizar(server, user, key));
				
		tabbedPane.addTab("Remover", new JProdutoRemover(server, user, key));
		
		tabbedPane.addTab("Procurar", new JProdutoProcurar(server, user, key));
	}

}
