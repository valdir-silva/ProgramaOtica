package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JProdutoInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JProdutoInserir instance;
	
	public static JProdutoInserir getInstance() {
		if (instance == null) {
			instance = new JProdutoInserir();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JProdutoInserir() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelProdutoInserir, null);
		
		JLabel lblInserir = new JLabel("Inserir");
		panelProdutoInserir.add(lblInserir);
		
	}

}
