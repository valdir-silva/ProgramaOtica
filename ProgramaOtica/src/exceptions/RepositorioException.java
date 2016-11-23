package exceptions;

public class RepositorioException extends Exception {

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