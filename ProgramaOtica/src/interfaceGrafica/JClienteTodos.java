package interfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioClienteArray;

public class JClienteTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public JClienteTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelClienteTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelClienteTodos, null);
		///////////
		//Tabela///
		///////////		
		String [] colunas = {"id", "Estado", "cidade", "Rua", "Cep", "Nascimento", "Nome", "CPF", "Telefone"};
		String [][] dados = null;
		
		RepositorioClienteArray clientes = new RepositorioClienteArray();

		Fachada instance = Fachada.getInstance(server, user, key);
		Fachada fachada = instance;
		
		clientes = fachada.todosClientes();
		dados = clientes.todosClientes();
		
		panelClienteTodos.setLayout(null);
		
		table = new JTable(dados, colunas);
		table.setBounds(0, 0, 680, 528);
		
		panelClienteTodos.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(680, 0, 17, 277);
		panelClienteTodos.add(scrollBar);
		

		tabbedPane.addTab("Inserir", new JClienteInserir(server, user, key));
		
		tabbedPane.addTab("Atualizar", new JClienteAtualizar(server, user, key));
				
		tabbedPane.addTab("Remover", new JClienteRemover(server, user, key));
		
		tabbedPane.addTab("Procurar", new JClienteProcurar(server, user, key));
	
	}

}
