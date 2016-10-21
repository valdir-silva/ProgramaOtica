package exceptions;

public class SemPosicaoParaInserirException extends Exception {
	public SemPosicaoParaInserirException() {
		super("Não existem mais posições livres para inserir!!");
	}
}
