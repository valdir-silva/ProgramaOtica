package exceptions;

import javax.swing.JOptionPane;

public class QuantidadeProdutoInvalidaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public QuantidadeProdutoInvalidaException() {
		super("Não existe produto disponível para ser comprado!!");
		JOptionPane.showMessageDialog(null, "Não existe produto disponível para ser comprado!!");
	}
}
