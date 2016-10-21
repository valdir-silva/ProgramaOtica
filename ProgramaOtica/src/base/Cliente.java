package base;

import exceptions.TamanhoException;

public class Cliente {
	private String nome;
	private String nascimento;
	private String cpf;
	private String telefone;
	private Endereco endereco;
	private int id;
	
	public String getNome () {		
		return this.nome;
	}
	
	public void setNome (String nome) throws TamanhoException {
		if (nome.length()<20){
			this.nome = nome;			
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
	}
	
	public String getNascimento () {		
		return this.nascimento;
	}
	
	public void setNascimento (String nascimento) throws TamanhoException {
		if (nascimento.length() > 6 && nascimento.length() < 11) {
			this.nascimento = nascimento;
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
		if (telefone.length() < 12 && telefone.length() > 8) {
			this.telefone = telefone;
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
	}
	
	public String getTelefone () {
		return this.telefone;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId () {
		return this.id;
	}
}
