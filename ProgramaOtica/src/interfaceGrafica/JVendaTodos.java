package interfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioVendaArray;

public class JVendaTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public JVendaTodos(String server, String user, String key) throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelVendaTodos, null);
		
		String [] colunas = {"id", "Id cliente", "Id produto"};
		String [][] dados = null;
		
		RepositorioVendaArray vendas = new RepositorioVendaArray();

		Fachada instance = Fachada.getInstance(server, user, key);
		Fachada fachada = instance;
		
		vendas = fachada.todasVendas();
		dados = vendas.todasVendas();
		
		panelVendaTodos.setLayout(null);
		
		table = new JTable(dados, colunas);
		table.setBounds(0, 0, 680, 528);
		
		panelVendaTodos.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(680, 0, 17, 277);
		panelVendaTodos.add(scrollBar);
		
		tabbedPane.addTab("Inserir", new JVendaInserir(server, user, key));
		
		tabbedPane.addTab("Atualizar", new JVendaAtualizar(server, user, key));
				
		tabbedPane.addTab("Remover", new JVendaRemover(server, user, key));
		
		tabbedPane.addTab("Procurar", new JVendaProcurar(server, user, key));
	}

}
