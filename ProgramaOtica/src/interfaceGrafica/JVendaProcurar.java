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
	private JTextField textFieldNomeCliente;
	private JTextField txtId;
	//declaração de objetos aqui para ser possível usar nos dois métodos (carregar e atualizar)
	Venda venda = new Venda();
	Fachada fachada;
	private JTextField textFieldTotal;
	private JTextField textFieldData;
	
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
		textFieldIdCliente.setBounds(120, 64, 100, 20);
		panelVendaProcurar.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JLabel lblNomeCliente = new JLabel("Nome do cliente");
		lblNomeCliente.setBounds(10, 103, 100, 14);
		panelVendaProcurar.add(lblNomeCliente);
		
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setBounds(120, 103, 100, 20);
		panelVendaProcurar.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);
		
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
					textFieldIdCliente.setText(Integer.toString(venda.getIdCliente()));
					textFieldNomeCliente.setText(fachada.procurarCliente(venda.getIdCliente()).getNome());
					textFieldData.setText(venda.getData());
					textFieldTotal.setText(Float.toString(venda.getTotal()));
				} catch (NullPointerException | RepositorioException | TamanhoException | IdNaoExisteException e) {

					e.printStackTrace();
				}				
			}
		});
		btnProcurar.setBounds(139, 25, 89, 23);
		panelVendaProcurar.add(btnProcurar);
		
		JLabel lblTotal = new JLabel("Total comprado");
		lblTotal.setBounds(11, 247, 86, 14);
		panelVendaProcurar.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBounds(120, 244, 86, 20);
		panelVendaProcurar.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JLabel lblData = new JLabel("Data da venda");
		lblData.setBounds(11, 139, 86, 14);
		panelVendaProcurar.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(120, 139, 86, 20);
		panelVendaProcurar.add(textFieldData);
		textFieldData.setColumns(10);

		
	}
}