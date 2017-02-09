package interfaceGrafica;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JVendaRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaRemover instance;
	private JTextField textFieldId;
	
	public static JVendaRemover getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaRemover(server,user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaRemover(String server, String user, String key) {
setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelVendaRemover, null);
		panelVendaRemover.setLayout(null);
		
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setBounds(336, 5, 68, 14);
		panelVendaRemover.add(lblRemover);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(44, 95, 46, 14);
		panelVendaRemover.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(66, 92, 86, 20);
		panelVendaRemover.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.setBounds(162, 91, 89, 23);
		panelVendaRemover.add(btnRemover);
		
	}
}
