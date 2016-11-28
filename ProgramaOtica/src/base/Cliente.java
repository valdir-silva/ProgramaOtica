package base;

import exceptions.TamanhoException;

public class Cliente extends Identificacao{
	private String nascimento;
	private Endereco endereco;
	
	public Cliente() {
		super();
	}
	
	public String getNome () {		
		return super.getNome();
	}
	
	public void setNome (String nome) throws TamanhoException {
		super.setNome(nome);
	}
	
	public String getNascimento () {		
		return this.nascimento;
	}
	
	public void setNascimento (String nascimento) throws TamanhoException {
		if (nascimento.length() < 11) {
			this.nascimento = nascimento;
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
		
	}
	
	public void setCpf (String cpf) throws TamanhoException {
		super.setCpf(cpf);
	}
	
	public String getCpf() {		
		return super.getCpf();
	}
	
	public void setTelefone (String telefone) throws TamanhoException {
		super.setTelefone(telefone);
	}
	
	public String getTelefone () {
		return super.getTelefone();
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setId(int id) {
		super.setId(id);
	}

	public int getId () {
		return super.getId();
	}
}
