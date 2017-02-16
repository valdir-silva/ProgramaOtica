package exceptions;

import javax.swing.JOptionPane;

public class RepositorioJaExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepositorioJaExisteException() {
		super("Repositório já existe!!");
		JOptionPane.showMessageDialog(null, "Repositório já existe!!");
	}
}
