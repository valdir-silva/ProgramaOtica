package base;

import exceptions.TamanhoException;

public class Identificacao {
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	
	public Identificacao() {
	
	}

	public String getNome () {		
		return this.nome;
	}
	
	public void setNome (String nome) throws TamanhoException {
		if (nome.length()<50){
			this.nome = nome;			
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
	}
	
	public void setCpf (String cpf) throws TamanhoException {
		if (cpf.length() == 11) {
			this.cpf = cpf;
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
		
	}
	
	public String getCpf() {		
		return this.cpf;
	}
	
	public void setTelefone (String telefone) throws TamanhoException {
		if (telefone.length() <= 12) {
			this.telefone = telefone;
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
	}
	
	public String getTelefone () {
		return this.telefone;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId () {
		return this.id;
	}

}
