package interfaceGrafica;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JProdutoPesquisar extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JClienteInserir frame = new JClienteInserir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JProdutoPesquisar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEncerrar = new JButton("Encerrar");
		btnEncerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEncerrar.setBounds(582, 29, 96, 23);
		contentPane.add(btnEncerrar);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCliente.setBounds(48, 212, 227, 66);
		contentPane.add(lblCliente);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(27, 29, 300, 40);
		contentPane.add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JButton btnInserir = new JButton("Inserir");
		mnCliente.add(btnInserir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		mnCliente.add(btnAtualizar);
		
		JButton btnRemover = new JButton("Remover");
		mnCliente.add(btnRemover);
		
		JButton btnProcurar = new JButton("Procurar");
		mnCliente.add(btnProcurar);
		
		JMenu mnFuncionario = new JMenu("Funcionario");
		menuBar.add(mnFuncionario);
		
		JButton button = new JButton("Inserir");
		mnFuncionario.add(button);
		
		JButton button_1 = new JButton("Atualizar");
		mnFuncionario.add(button_1);
		
		JButton button_2 = new JButton("Remover");
		mnFuncionario.add(button_2);
		
		JButton button_3 = new JButton("Procurar");
		mnFuncionario.add(button_3);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JButton button_4 = new JButton("Inserir");
		mnProduto.add(button_4);
		
		JButton button_5 = new JButton("Atualizar");
		mnProduto.add(button_5);
		
		JButton button_6 = new JButton("Remover");
		mnProduto.add(button_6);
		
		JButton button_7 = new JButton("Procurar");
		mnProduto.add(button_7);
		
		JMenu menu = new JMenu("Venda");
		menuBar.add(menu);
		
		JButton button_8 = new JButton("Inserir");
		menu.add(button_8);
		
		JButton button_9 = new JButton("Atualizar");
		menu.add(button_9);
		
		JButton button_10 = new JButton("Remover");
		menu.add(button_10);
		
		JButton button_11 = new JButton("Procurar");
		menu.add(button_11);
	}
}
