package interfaceGrafica;


import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioFuncionarioArray;

public class JFuncionarioTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private static JFuncionarioTodos instance;

	static JFuncionarioTodos getInstance(String server, String user, String key) throws TamanhoException {
		if (instance == null) {
			instance = new JFuncionarioTodos(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}
	
	private JFuncionarioTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelFuncionarioTodos, null);
		panelFuncionarioTodos.setLayout((new GridLayout(1, 1)));
		
		///////////
		//Tabela///
		///////////		
		
		String [] colunas = {"id", "nome", "cpf", "telefone"};
		String [][] dados = null;
			
		RepositorioFuncionarioArray funcionarios = new RepositorioFuncionarioArray();
		Fachada fachada = Fachada.getInstance(server, user, key);
					
		try {
			funcionarios = fachada.todosFuncionarios();
			dados = funcionarios.todosFuncionarios();
		} catch (TamanhoException e) {
			e.printStackTrace();
		}
					
		table = new JTable(dados, colunas);
					
		JScrollPane scrollPane = new JScrollPane(table);
		panelFuncionarioTodos.add(scrollPane);
			
		
		tabbedPane.addTab("Inserir", JFuncionarioInserir.getInstance(server, user, key));
		
		tabbedPane.addTab("Atualizar", JFuncionarioAtualizar.getInstance(server, user, key));
				
		tabbedPane.addTab("Remover", JFuncionarioRemover.getInstance(server, user, key));
		
		tabbedPane.addTab("Procurar", JFuncionarioProcurar.getInstance(server, user, key));
	}
}
