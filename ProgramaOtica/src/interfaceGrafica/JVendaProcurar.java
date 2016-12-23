package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JVendaProcurar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaProcurar instance;
	
	public static JVendaProcurar getInstance() {
		if (instance == null) {
			instance = new JVendaProcurar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaProcurar() {
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
