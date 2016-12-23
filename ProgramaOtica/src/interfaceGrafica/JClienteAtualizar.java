package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JClienteAtualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JClienteAtualizar instance;
	
	public static JClienteAtualizar getInstance() {
		if (instance == null) {
			instance = new JClienteAtualizar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JClienteAtualizar() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelClienteAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelClienteAtualizar, null);
		
		JLabel lblInserir = new JLabel("Atualizar");
		panelClienteAtualizar.add(lblInserir);
	}
}
