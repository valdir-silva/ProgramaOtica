package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JClienteInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JClienteInserir instance;
	
	public static JClienteInserir getInstance() {
		if (instance == null) {
			instance = new JClienteInserir();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JClienteInserir() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelClienteInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelClienteInserir, null);
		
		JLabel lblInserir = new JLabel("Inserir");
		panelClienteInserir.add(lblInserir);
		
	}
}
