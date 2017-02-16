package exceptions;

import javax.swing.JOptionPane;

public class IdNaoExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdNaoExisteException() {
		super("Id procurado não existe!!");
		JOptionPane.showMessageDialog(null, "Id procurado não existe!!");
	}
}
