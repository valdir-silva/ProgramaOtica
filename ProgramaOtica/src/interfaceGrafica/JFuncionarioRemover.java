package interfaceGrafica;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JFuncionarioRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFuncionarioRemover instance;
	
	private JTextField textFieldId;
	
	public static JFuncionarioRemover getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JFuncionarioRemover(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JFuncionarioRemover(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelFuncionarioRemover, null);
		panelFuncionarioRemover.setLayout(null);
		
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setBounds(336, 5, 68, 14);
		panelFuncionarioRemover.add(lblRemover);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(44, 95, 46, 14);
		panelFuncionarioRemover.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(66, 92, 86, 20);
		panelFuncionarioRemover.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.setBounds(162, 91, 89, 23);
		panelFuncionarioRemover.add(btnRemover);
	}
	
}
