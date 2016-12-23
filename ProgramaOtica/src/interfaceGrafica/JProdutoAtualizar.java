package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JProdutoAtualizar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JProdutoAtualizar instance;
	
	public static JProdutoAtualizar getInstance() {
		if (instance == null) {
			instance = new JProdutoAtualizar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JProdutoAtualizar() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelProdutoAtualizar, null);
		
		JLabel lblInserir = new JLabel("Atualizar");
		panelProdutoAtualizar.add(lblInserir);
		
	}
	
}
