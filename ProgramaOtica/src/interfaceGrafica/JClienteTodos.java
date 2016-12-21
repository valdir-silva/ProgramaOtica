package interfaceGrafica;


import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioClienteArray;

import javax.swing.JScrollBar;

public class JClienteTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public JClienteTodos() throws TamanhoException {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelClienteTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelClienteTodos, null);
		
		String [] colunas = {"id", "Estado", "cidade", "Rua", "Cep", "Nascimento", "Nome", "CPF", "Telefone"};
		String [][] dados = null;
		
		RepositorioClienteArray clientes = new RepositorioClienteArray();

		Fachada instance = Fachada.getInstance();
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
		

		
		JPanel panelClienteInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelClienteInserir, null);
		
		JLabel lblInserir = new JLabel("Inserir");
		panelClienteInserir.add(lblInserir);
		
		JPanel panelClienteAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelClienteAtualizar, null);
		
		JLabel lblNewLabel = new JLabel("Atualizar");
		panelClienteAtualizar.add(lblNewLabel);
		
		JPanel panelClienteRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelClienteRemover, null);
		
		JLabel lblRemover = new JLabel("Remover");
		panelClienteRemover.add(lblRemover);
		
		JPanel panelClienteProcurar = new JPanel();
		tabbedPane.addTab("Procurar", null, panelClienteProcurar, null);
		
		JLabel lblNewLabel_1 = new JLabel("Procurar");
		panelClienteProcurar.add(lblNewLabel_1);
	}
}
