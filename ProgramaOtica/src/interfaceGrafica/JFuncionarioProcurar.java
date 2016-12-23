package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JFuncionarioProcurar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFuncionarioProcurar instance;
	
	public static JFuncionarioProcurar getInstance() {
		if (instance == null) {
			instance = new JFuncionarioProcurar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JFuncionarioProcurar() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioProcurar = new JPanel();
		tabbedPane.addTab("Procurar", null, panelFuncionarioProcurar, null);
		
		JLabel lblInserir = new JLabel("Procurar");
		panelFuncionarioProcurar.add(lblInserir);
	}

}
