package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioProdutoArray;

public class JProdutoTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private static JProdutoTodos instance;

	static JProdutoTodos getInstance(String server, String user, String key) throws TamanhoException {
		if (instance == null) {
			instance = new JProdutoTodos(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}
	
	private JProdutoTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelJProdutoTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelJProdutoTodos, null);
		panelJProdutoTodos.setLayout((new GridLayout(1, 1)));
		
		///////////
		//Tabela///
		///////////
		String [] colunas = {"id", "Nome", "Marca", "ValorCompra", "ValorVenda", "Quantidade"};
		String [][] dados = null;
				
		RepositorioProdutoArray produtos = new RepositorioProdutoArray();
		Fachada fachada = Fachada.getInstance(server, user, key);
				
		try {
			produtos = fachada.todosProdutos();
			dados = produtos.todosProdutos();
		} catch (TamanhoException e) {
			e.printStackTrace();
		}
				
		table = new JTable(dados, colunas);
				
		JScrollPane scrollPane = new JScrollPane(table);
		panelJProdutoTodos.add(scrollPane);

		
		tabbedPane.addTab("Inserir", JProdutoInserir.getInstance(server, user, key));
		
		tabbedPane.addTab("Atualizar", JProdutoAtualizar.getInstance(server, user, key));
				
		tabbedPane.addTab("Remover", JProdutoRemover.getInstance(server, user, key));
		
		tabbedPane.addTab("Procurar", JProdutoProcurar.getInstance(server, user, key));
	}

}
