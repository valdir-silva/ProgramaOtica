package exceptions;

public class TamanhoException extends Exception{
	/*
	 *Cliente:
	 *
	 * nome < 50
	 * cpf = 11
	 * telefone > 8 && telefone < 12
	 * cep = 8
	 * nascimento > 6 && nascimento < 11
	 * 
	 * Produto:
	 * 
	 * marca < 40
	 */
	
	
	public TamanhoException () {
		super("Tamanho nao confere!!");
	}
	
}
