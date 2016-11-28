package exceptions;

public class RepositorioException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Exception exception;

    public RepositorioException(Exception exception) {
        super("Exce��o encapsulada");
        this.exception = exception;
    }

    public String getMessage() {
        return exception.getMessage();
    }

    public void printStackTrace() {
        exception.printStackTrace();
    }

}