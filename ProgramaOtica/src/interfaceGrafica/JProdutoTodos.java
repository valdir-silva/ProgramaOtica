package interfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
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
		
		String [] colunas = {"id", "Nome", "Marca", "ValorCompra", "ValorVenda"};
		String [][] dados = null;
		
		RepositorioProdutoArray produtos = new RepositorioProdutoArray();

		Fachada instance = Fachada.getInstance(server, user, key);
		Fachada fachada = instance;
		
		produtos = fachada.todosProdutos();
		dados = produtos.todosProdutos();
		
		
		panelJProdutoTodos.setLayout(null);
		
		table = new JTable(dados, colunas);
		table.setBounds(0, 0, 680, 528);
		
		panelJProdutoTodos.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(680, 0, 17, 277);
		panelJProdutoTodos.add(scrollBar);
		

		
		tabbedPane.addTab("Inserir", new JProdutoInserir(server, user, key));
		
		tabbedPane.addTab("Atualizar", new JProdutoAtualizar(server, user, key));
				
		tabbedPane.addTab("Remover", new JProdutoRemover(server, user, key));
		
		tabbedPane.addTab("Procurar", new JProdutoProcurar(server, user, key));
	}

}
