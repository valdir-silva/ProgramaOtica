package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.Venda;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import programa.Fachada;

public class JVendaInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaInserir instance;
	private JTextField textFieldIdCliente;
	private JTextField textFieldIdProduto;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	
	public static JVendaInserir getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaInserir(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaInserir(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelVendaInserir, null);
		panelVendaInserir.setLayout(null);
		
		JLabel lblInserir = new JLabel("Inserir");
		lblInserir.setBounds(334, 0, 61, 14);
		panelVendaInserir.add(lblInserir);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(11, 64, 70, 14);
		panelVendaInserir.add(lblIdCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setBounds(91, 64, 148, 20);
		panelVendaInserir.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JLabel lblIdProduto = new JLabel("Id Produto");
		lblIdProduto.setBounds(10, 103, 71, 14);
		panelVendaInserir.add(lblIdProduto);
		
		textFieldIdProduto = new JTextField();
		textFieldIdProduto.setBounds(91, 103, 148, 20);
		panelVendaInserir.add(textFieldIdProduto);
		textFieldIdProduto.setColumns(10);
		
		
		JButton btnInserirVenda = new JButton("Inserir Venda");
		btnInserirVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda.setCliente(Integer.parseInt(textFieldIdCliente.getText()));
					venda.setProduto(Integer.parseInt(textFieldIdProduto.getText()));
					fachada.inserir(venda);
				} catch (TamanhoException | RepositorioException | NullPointerException | SemPosicaoParaInserirException e) {
					e.printStackTrace();
				}
			}
		});
		btnInserirVenda.setBounds(355, 257, 131, 23);
		panelVendaInserir.add(btnInserirVenda);
		
	}
	
}
