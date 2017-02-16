package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioVendaArray;

public class JVendaTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private static JVendaTodos instance;

	static JVendaTodos getInstance(String server, String user, String key) throws TamanhoException {
		if (instance == null) {
			instance = new JVendaTodos(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JVendaTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelVendaTodos, null);
		panelVendaTodos.setLayout((new GridLayout(1, 1)));
		
		///////////
		//Tabela///
		///////////
		String [] colunas = {"id", "Id cliente", "Id produto", "Quantidade"};
		String [][] dados = null;
				
		RepositorioVendaArray vendas = new RepositorioVendaArray();
		Fachada fachada = Fachada.getInstance(server, user, key);
				
		try {
			vendas = fachada.todasVendas();
			dados = vendas.todasVendas();
		} catch (TamanhoException e) {
			e.printStackTrace();
		}
				
		table = new JTable(dados, colunas);
				
		JScrollPane scrollPane = new JScrollPane(table);
		panelVendaTodos.add(scrollPane);
		
		tabbedPane.addTab("Inserir", JVendaInserir.getInstance(server, user, key));
		
		tabbedPane.addTab("Atualizar", JVendaAtualizar.getInstance(server, user, key));
				
		tabbedPane.addTab("Remover", JVendaRemover.getInstance(server, user, key));
		
		tabbedPane.addTab("Procurar", JVendaProcurar.getInstance(server, user, key));
	}

}
