package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JVendaInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaInserir instance;
	
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
		tabbedPane.addTab("Venda", null, panelVendaInserir, null);
		
		JLabel lblInserir = new JLabel("Venda");
		panelVendaInserir.add(lblInserir);
		
	}
	
}
