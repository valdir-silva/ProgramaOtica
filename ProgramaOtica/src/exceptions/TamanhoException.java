package exceptions;

import javax.swing.JOptionPane;

public class TamanhoException extends Exception{
	/*
	 *Cliente:
	 *
	 * nome < 50
	 * cpf = 11
	 * telefone <= 12
	 * cep <= 10
	 * nascimento < 11
	 * 
	 * Produto:
	 * 
	 * marca < 40
	 */
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TamanhoException () {
		super("Tamanho nao confere!!");
		JOptionPane.showMessageDialog(null, "Tamanho nao confere!!");
	}
	
}
