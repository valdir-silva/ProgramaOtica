package interfaceGrafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.TamanhoException;

import javax.swing.JTabbedPane;

public class JPrograma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JPrograma instance;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrograma frame = new JPrograma("","",""); //talvez precise trazer as variaveis prak
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static JPrograma getInstance(String server, String user, String key) {
		if(instance == null) {
			instance = new JPrograma(server,user,key); //talvez precise trazer as variaveis prak
			return instance;
		}else {	
			return instance;
		}
	}

	/**
	 * Create the frame.
	 */
	private JPrograma(String server, String user, String key) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 704, 490);
		contentPane.add(tabbedPane);
		
		JPanel panelInicio = new JPanel();
		tabbedPane.addTab("Inicio", null, panelInicio, null);
		
		try {
			tabbedPane.addTab("Cliente", JClienteTodos.getInstance(server, user, key));
			
			tabbedPane.addTab("Funcionario", JFuncionarioTodos.getInstance(server, user, key));
			
			tabbedPane.addTab("Produto", JProdutoTodos.getInstance(server, user, key));
			
			tabbedPane.addTab("Venda", JVendaTodos.getInstance(server, user, key));
			
		} catch (TamanhoException e) {
			e.printStackTrace();
		}
		
	}
}
