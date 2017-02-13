package exceptions;

public class IdNaoExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdNaoExisteException() {
		super("Id procurado não existe!!");
	}
}
