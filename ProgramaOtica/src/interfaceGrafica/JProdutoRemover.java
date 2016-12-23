package interfaceGrafica;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JProdutoRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JProdutoRemover instance;
	
	public static JProdutoRemover getInstance() {
		if (instance == null) {
			instance = new JProdutoRemover();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JProdutoRemover() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelProdutoRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelProdutoRemover, null);
		
		JLabel lblInserir = new JLabel("Remover");
		panelProdutoRemover.add(lblInserir);
		
	}

}
