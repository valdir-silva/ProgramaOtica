package exceptions;

import javax.swing.JOptionPane;

public class QuantidadeEstoqueMenorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuantidadeEstoqueMenorException() {
		super("nao existe essa quantidade em estoque");
		JOptionPane.showMessageDialog(null, "nao existe essa quantidade em estoque");
	}

}
