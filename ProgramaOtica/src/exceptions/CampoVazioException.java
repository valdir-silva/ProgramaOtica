package exceptions;

import javax.swing.JOptionPane;

public class CampoVazioException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CampoVazioException () {
		super("Preencha todos os campos");
		JOptionPane.showMessageDialog(null, "Preencha todos os campos");
	}
}
