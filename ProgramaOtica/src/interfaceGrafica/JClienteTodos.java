package interfaceGrafica;

import javax.swing.JPanel;


import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioClienteArray;
import javax.swing.JScrollPane;

import java.awt.GridLayout;

public class JClienteTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private static JClienteTodos instance;

	static JClienteTodos getInstance(String server, String user, String key) throws TamanhoException {
		if (instance == null) {
			instance = new JClienteTodos(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}
	
	private JClienteTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelClienteTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelClienteTodos, null);
		panelClienteTodos.setLayout((new GridLayout(1, 1)));

		///////////
		//Tabela///
		///////////
		String [] colunas = {"id", "Estado", "cidade", "Rua", "Cep", "Nascimento", "Nome", "CPF", "Telefone"};
		String [][] dados = null;
		
		RepositorioClienteArray clientes = new RepositorioClienteArray();
		
		Fachada fachada = Fachada.getInstance(server, user, key);
				
		try {
			clientes = fachada.todosClientes();
			dados = clientes.todosClientes();
		} catch (TamanhoException e) {
			e.printStackTrace();
		}	
		
		table = new JTable(dados, colunas);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panelClienteTodos.add(scrollPane);
				
		
		tabbedPane.addTab("Inserir", JClienteInserir.getInstance(server, user, key));
		
		tabbedPane.addTab("Atualizar", JClienteAtualizar.getInstance(server, user, key));
				
		tabbedPane.addTab("Remover", JClienteRemover.getInstance(server, user, key));
		
		tabbedPane.addTab("Procurar", JClienteProcurar.getInstance(server, user, key));
	
	}

	
}
