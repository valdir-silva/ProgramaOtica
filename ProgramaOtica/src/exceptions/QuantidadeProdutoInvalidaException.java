package exceptions;

public class QuantidadeProdutoInvalidaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public QuantidadeProdutoInvalidaException() {
		super("Não existe produto disponível para ser comprado!!");
	}
}
