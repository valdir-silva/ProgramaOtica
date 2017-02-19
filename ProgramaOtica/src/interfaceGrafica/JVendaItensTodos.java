package interfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import exceptions.CampoVazioException;
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
		
		JLabel lblIdProduto = new JLabel("Id Produto");
		lblIdProduto.setBounds(10, 324, 80, 14);
		panelVendaItensTodos.add(lblIdProduto);
		
		textFieldIdProduto = new JTextField();
		textFieldIdProduto.setBounds(100, 321, 86, 20);
		panelVendaItensTodos.add(textFieldIdProduto);
		textFieldIdProduto.setColumns(10);
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
				
		JButton btnProcurarProduto = new JButton("Procurar Item Vendido");
		btnProcurarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textFieldIdProduto.getText() != null) {
						String dadosString = null;
						int idVenda;
						RepositorioItemVendaArray vendas = new RepositorioItemVendaArray();
						Fachada fachada = Fachada.getInstance(server, user, key);
						String [][] dados = null;		
						
						idVenda = Integer.parseInt(textFieldIdProduto.getText());
					
						vendas = fachada.todosItensVenda(idVenda);
						dados = vendas.todosItensVenda();
						
						if(dados[0][0] != null) {
							dadosString = toString(dados);
							textArea.append(dadosString + "\n");
						}
					}else {
						throw new CampoVazioException();
					}
				} catch (TamanhoException | CampoVazioException e) {
					e.printStackTrace();
				}
				
				
			}

			private String toString(String[][] dados) {
				String dado = "";
				int i;
				for(i = 0; i < dados.length; i++) {
					for(int j = 0; j < 4; j++) {//quantos atributos existe
						if(dados[i][j] != null)
							dado += dados[i][j]+ "\t";
					}
					if(dados[i][0] != null)
						dado += "\n";
				}
				
				return dado;
			}
		});
		btnProcurarProduto.setBounds(10, 349, 178, 28);
		panelVendaItensTodos.add(btnProcurarProduto);
		
		
		
	}
}
