package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JClienteProcurar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JClienteProcurar instance;
	
	public static JClienteProcurar getInstance() {
		if (instance == null) {
			instance = new JClienteProcurar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JClienteProcurar() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
						
		JPanel panelClienteProcurar = new JPanel();
		tabbedPane.addTab("Procurar", null, panelClienteProcurar, null);
		
		JLabel lblNewLabel_1 = new JLabel("Procurar");
		panelClienteProcurar.add(lblNewLabel_1);
	}
}
