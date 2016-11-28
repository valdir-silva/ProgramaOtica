package exceptions;

public class SemPosicaoParaInserirException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SemPosicaoParaInserirException() {
		super("Não existem mais posições livres para inserir!!");
	}
}
