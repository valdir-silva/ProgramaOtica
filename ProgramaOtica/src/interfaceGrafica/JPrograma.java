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
					JPrograma frame = new JPrograma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static JPrograma getInstance() {
		if(instance == null) {
			instance = new JPrograma();
			return instance;
		}else {	
			return instance;
		}
	}

	/**
	 * Create the frame.
	 */
	public JPrograma() {
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
			tabbedPane.addTab("Cliente", new JClienteTodos());
			tabbedPane.addTab("Funcionario", new JFuncionarioTodos());
			tabbedPane.addTab("Produto", new JProdutoTodos());
			tabbedPane.addTab("Venda", new JVendaTodos());
			
		} catch (TamanhoException e) {
			e.printStackTrace();
		}
		
	}
}
