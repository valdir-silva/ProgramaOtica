package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JProdutoProcurar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JProdutoProcurar instance;
	
	public static JProdutoProcurar getInstance(String server, String user, String key) {
		if (instance == null) {
			instance = new JProdutoProcurar(server, user, key);
			return instance;
		}
		else {
			return instance;
		}
	}

	public JProdutoProcurar(String server, String user, String key) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoProcurar = new JPanel();
		tabbedPane.addTab("Procurar", null, panelProdutoProcurar, null);
		
		JLabel lblInserir = new JLabel("Procurar");
		panelProdutoProcurar.add(lblInserir);
		
	}
	
}
