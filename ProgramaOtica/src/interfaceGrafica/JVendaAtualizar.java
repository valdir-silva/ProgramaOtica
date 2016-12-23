package interfaceGrafica;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JVendaAtualizar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaAtualizar instance;
	
	public static JVendaAtualizar getInstance() {
		if (instance == null) {
			instance = new JVendaAtualizar();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaAtualizar() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaAtualizar = new JPanel();
		tabbedPane.addTab("Atualizar", null, panelVendaAtualizar, null);
		
		JLabel lblInserir = new JLabel("Atualizar");
		panelVendaAtualizar.add(lblInserir);
		
	}
}
