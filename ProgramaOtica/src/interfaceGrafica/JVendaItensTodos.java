package interfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import exceptions.TamanhoException;
import programa.Fachada;
import repositorios.RepositorioItemVendaArray;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JVendaItensTodos extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JVendaItensTodos instance;
	private JTextField textFieldIdProduto;
	private JTextArea textArea;

	public static JVendaItensTodos getInstance(String server, String user, String key) {
		if(instance == null) {
			instance = new JVendaItensTodos(server, user, key);
			return instance;
		}else
			return instance;
	}
		
	private JVendaItensTodos(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaItensTodos = new JPanel();
		tabbedPane.addTab("Todos", null, panelVendaItensTodos, null);
		panelVendaItensTodos.setLayout(null);
		///////////
		//Tabela///
		///////////
		String colunas = "id\t Id cliente\t total\t Data\n";		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 602, 290);
		panelVendaItensTodos.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);		
		textArea.append(colunas);
				
		JButton btnProcurarProduto = new JButton("Procurar Produto");
		btnProcurarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RepositorioItemVendaArray vendas = new RepositorioItemVendaArray();
				Fachada fachada = Fachada.getInstance(server, user, key);
				String [][] dados = null;		
				try {
					vendas = fachada.todosItensVenda();
					dados = vendas.todosItensVenda();
				} catch (TamanhoException e) {
					e.printStackTrace();
				}
				if(dados != null)
					textArea.append(dados.toString() + "\n");
			}
		});
		btnProcurarProduto.setBounds(20, 349, 122, 23);
		panelVendaItensTodos.add(btnProcurarProduto);
		
		JLabel lblIdProduto = new JLabel("Id Produto");
		lblIdProduto.setBounds(10, 324, 64, 14);
		panelVendaItensTodos.add(lblIdProduto);
		
		textFieldIdProduto = new JTextField();
		textFieldIdProduto.setBounds(83, 318, 86, 20);
		panelVendaItensTodos.add(textFieldIdProduto);
		textFieldIdProduto.setColumns(10);
		
		
	}
}
