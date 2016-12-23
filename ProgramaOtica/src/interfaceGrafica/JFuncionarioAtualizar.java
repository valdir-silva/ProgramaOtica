package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JFuncionarioAtualizar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JFuncionarioAtualizar instance;
	
	public static JFuncionarioAtualizar getInstance() {
		if (instance == null) {
			instance = new JFuncionarioAtualizar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JFuncionarioAtualizar() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelFuncionarioAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelFuncionarioAtualizar, null);
		
		JLabel lblInserir = new JLabel("Atualizar");
		panelFuncionarioAtualizar.add(lblInserir);
	}

}
