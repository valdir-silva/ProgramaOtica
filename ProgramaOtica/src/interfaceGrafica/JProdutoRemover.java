package interfaceGrafica;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JProdutoRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JProdutoRemover instance;
	private JTextField textFieldId;
	
	public static JProdutoRemover getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JProdutoRemover(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JProdutoRemover(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelProdutoRemover, null);
		panelProdutoRemover.setLayout(null);
		
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setBounds(336, 5, 68, 14);
		panelProdutoRemover.add(lblRemover);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(44, 95, 46, 14);
		panelProdutoRemover.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(66, 92, 86, 20);
		panelProdutoRemover.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.setBounds(162, 91, 89, 23);
		panelProdutoRemover.add(btnRemover);
		
	}

}
