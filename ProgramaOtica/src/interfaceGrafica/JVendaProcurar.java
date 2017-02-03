package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JVendaProcurar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaProcurar instance;
	
	public static JVendaProcurar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JVendaProcurar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaProcurar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaProcurar = new JPanel();
		tabbedPane.addTab("Procurar", null, panelVendaProcurar, null);
		
		JLabel lblInserir = new JLabel("Procurar");
		panelVendaProcurar.add(lblInserir);
		
	}

}
