package exceptions;

public class RemocaoNaoConcluidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RemocaoNaoConcluidaException (){
		super("Remoção não concluída!!");
	}
}
