package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JProdutoProcurar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JProdutoProcurar instance;
	
	public static JProdutoProcurar getInstance() {
		if (instance == null) {
			instance = new JProdutoProcurar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JProdutoProcurar() {
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
