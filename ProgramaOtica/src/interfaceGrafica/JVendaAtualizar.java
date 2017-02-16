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

public class JVendaAtualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaAtualizar instance;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	private JTextField txtId;
	private JTextField textFieldIdCliente;
	private JTextField textFieldData;
	private JTextField textFieldTotal;
	
	public static JVendaAtualizar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaAtualizar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	private JVendaAtualizar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelVendaAtualizar, null);
		panelVendaAtualizar.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(334, 0, 61, 14);
		panelVendaAtualizar.add(lblAtualizar);
		
		
		JButton btnAtualizarVenda = new JButton("Atualizar Venda");
		btnAtualizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda.setIdCliente(Integer.parseInt(textFieldIdCliente.getText()));
					venda.setTotal(Integer.parseInt(textFieldTotal.getText()));
					venda.setData(textFieldData.getText());
					
					//implementar Itens Venda
					fachada.atualizar(venda);
				} catch (TamanhoException | RepositorioException e) {
					e.printStackTrace();
				}
			}
		});
		btnAtualizarVenda.setBounds(355, 257, 131, 23);
		panelVendaAtualizar.add(btnAtualizarVenda);
		
		JButton btnCarregar = new JButton("carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(txtId.getText());
				fachada = Fachada.getInstance(server, user, key);
				try {
					venda = fachada.procurarVenda(id);
					textFieldIdCliente.setText(Integer.toString(venda.getIdCliente()));
					textFieldData.setText(venda.getData());
					textFieldTotal.setText(Float.toString(venda.getTotal()));
				} catch (NullPointerException | RepositorioException | TamanhoException | IdNaoExisteException e) {

					e.printStackTrace();
				}
			}
		});
		btnCarregar.setBounds(139, 25, 89, 23);
		panelVendaAtualizar.add(btnCarregar);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(10, 28, 26, 14);
		panelVendaAtualizar.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(46, 25, 86, 20);
		panelVendaAtualizar.add(txtId);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(11, 63, 70, 14);
		panelVendaAtualizar.add(lblIdCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBounds(120, 63, 100, 20);
		panelVendaAtualizar.add(textFieldIdCliente);
		
		JLabel lblData = new JLabel("Data da venda");
		lblData.setBounds(10, 94, 86, 14);
		panelVendaAtualizar.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		textFieldData.setBounds(119, 94, 86, 20);
		panelVendaAtualizar.add(textFieldData);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(120, 243, 86, 20);
		panelVendaAtualizar.add(textFieldTotal);
		
		JLabel lblTotal = new JLabel("Total comprado");
		lblTotal.setBounds(11, 246, 86, 14);
		panelVendaAtualizar.add(lblTotal);

		
	}
}
