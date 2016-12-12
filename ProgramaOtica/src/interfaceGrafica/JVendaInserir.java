package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JVendaInserir extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaInserir instance;
	
	public static JVendaInserir getInstance() {
		if (instance == null) {
			instance = new JVendaInserir();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaInserir() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 300);
		add(tabbedPane);
		
		JPanel panelClienteInserir = new JPanel();
		tabbedPane.addTab("New tab", null, panelClienteInserir, null);
		
		JLabel lblInserir = new JLabel("Inserir");
		panelClienteInserir.add(lblInserir);
		
		JPanel panelClienteAtualizar = new JPanel();
		tabbedPane.addTab("New tab", null, panelClienteAtualizar, null);
		
		JLabel lblNewLabel = new JLabel("Atualizar");
		panelClienteAtualizar.add(lblNewLabel);
		
		JPanel panelClienteRemover = new JPanel();
		tabbedPane.addTab("New tab", null, panelClienteRemover, null);
		
		JLabel lblRemover = new JLabel("Remover");
		panelClienteRemover.add(lblRemover);
		
		JPanel panelClienteProcurar = new JPanel();
		tabbedPane.addTab("New tab", null, panelClienteProcurar, null);
		
		JLabel lblNewLabel_1 = new JLabel("Procurar");
		panelClienteProcurar.add(lblNewLabel_1);
	}
	
}
