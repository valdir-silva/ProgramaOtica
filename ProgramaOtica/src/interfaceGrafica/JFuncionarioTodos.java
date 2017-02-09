package interfaceGrafica;


import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioFuncionarioArray;

public class JFuncionarioTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public JFuncionarioTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelFuncionarioTodos, null);
		
		String [] colunas = {"id", "nome", "cpf", "telefone"};
		String [][] dados = null;
		
		RepositorioFuncionarioArray funcionarios = new RepositorioFuncionarioArray();

		Fachada instance = Fachada.getInstance(server, user, key);
		Fachada fachada = instance;
		
		funcionarios = fachada.todosFuncionarios();
		dados = funcionarios.todosFuncionarios();
		
		
		panelFuncionarioTodos.setLayout(null);
		
		table = new JTable(dados, colunas);
		table.setBounds(0, 0, 680, 528);
		
		panelFuncionarioTodos.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(680, 0, 17, 277);
		panelFuncionarioTodos.add(scrollBar);
		

		
		tabbedPane.addTab("Inserir", new JFuncionarioInserir(server, user, key));
		
		tabbedPane.addTab("Atualizar", new JFuncionarioAtualizar(server, user, key));
				
		tabbedPane.addTab("Remover", new JFuncionarioRemover(server, user, key));
		
		tabbedPane.addTab("Procurar", new JFuncionarioProcurar(server, user, key));
	}
}
