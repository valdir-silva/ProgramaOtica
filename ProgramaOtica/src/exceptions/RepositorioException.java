package exceptions;

import javax.swing.JOptionPane;

public class RepositorioException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Exception exception;

    public RepositorioException(Exception exception) {
        super("Exceção encapsulada");
        JOptionPane.showMessageDialog(null, "Exceção encapsulada");
        this.exception = exception;
    }

    public String getMessage() {
        return exception.getMessage();
    }

    public void printStackTrace() {
        exception.printStackTrace();
    }

}