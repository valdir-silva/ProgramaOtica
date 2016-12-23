package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JFuncionarioInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFuncionarioInserir instance;
	
	public static JFuncionarioInserir getInstance() {
		if (instance == null) {
			instance = new JFuncionarioInserir();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JFuncionarioInserir() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioInserir = new JPanel();
		tabbedPane.addTab("Inserir", null, panelFuncionarioInserir, null);
		
		JLabel lblInserir = new JLabel("Inserir");
		panelFuncionarioInserir.add(lblInserir);
	}
}
