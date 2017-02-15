package interfaceGrafica;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Venda;
import exceptions.IdNaoExisteException;
import exceptions.RepositorioException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JVendaProcurar extends JPanel {


	private static final long serialVersionUID = 1L;
	private static JVendaProcurar instance;
	private JTextField textFieldIdCliente;
	private JTextField textFieldIdProduto;
	private JTextField txtId;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	
	public static JVendaProcurar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaProcurar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JVendaProcurar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaProcurar = new JPanel();
		tabbedPane.addTab("Procurar", null, panelVendaProcurar, null);
		panelVendaProcurar.setLayout(null);
		
		JLabel lblProcurar = new JLabel("Procurar");
		lblProcurar.setBounds(334, 0, 61, 14);
		panelVendaProcurar.add(lblProcurar);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(11, 64, 70, 14);
		panelVendaProcurar.add(lblIdCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setBounds(91, 64, 148, 20);
		panelVendaProcurar.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JLabel lblIdProduto = new JLabel("Id Produto");
		lblIdProduto.setBounds(10, 103, 71, 14);
		panelVendaProcurar.add(lblIdProduto);
		
		textFieldIdProduto = new JTextField();
		textFieldIdProduto.setBounds(91, 103, 148, 20);
		panelVendaProcurar.add(textFieldIdProduto);
		textFieldIdProduto.setColumns(10);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 29, 26, 14);
		panelVendaProcurar.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(46, 26, 86, 20);
		panelVendaProcurar.add(txtId);
		txtId.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(txtId.getText());
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda = fachada.procurarVenda(id);
				} catch (NullPointerException | RepositorioException | TamanhoException | IdNaoExisteException e) {

					e.printStackTrace();
				}
				//busca no banco e preenche todos os campos
				textFieldIdCliente.setText(Integer.toString(venda.getCliente()));
				textFieldIdProduto.setText(Integer.toString(venda.getProduto()));
			}
		});
		btnProcurar.setBounds(139, 25, 89, 23);
		panelVendaProcurar.add(btnProcurar);

		
	}

}