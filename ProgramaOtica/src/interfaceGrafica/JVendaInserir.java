package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JVendaInserir extends JPanel {

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

	public JVendaInserir() {
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
