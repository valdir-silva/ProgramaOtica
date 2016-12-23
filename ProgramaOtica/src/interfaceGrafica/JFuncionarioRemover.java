package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JFuncionarioRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JFuncionarioRemover instance;
	
	public static JFuncionarioRemover getInstance() {
		if (instance == null) {
			instance = new JFuncionarioRemover();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JFuncionarioRemover() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelFuncionarioRemover, null);
		
		JLabel lblInserir = new JLabel("Remover");
		panelFuncionarioRemover.add(lblInserir);
	}
	
}
