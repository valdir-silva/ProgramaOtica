package base;

import exceptions.TamanhoException;

public class Funcionario extends Identificacao{
	
	public Funcionario() {
		super();
	}
	
	public int getId() {
		return super.getId();
	}
	
	public void setId(int id) {
		super.setId(id);;
	}
	
	public String getNome() {
		return super.getNome();
	}
	
	public void setNome(String nome) throws TamanhoException {
		super.setNome(nome);
	}
	
	public String getCpf() {
		return super.getCpf();
	}
	
	public void setCpf(String cpf) throws TamanhoException {
		super.setCpf(cpf);
	}
	
	public String getTelefone() {
		return super.getTelefone();
	}
	
	public void setTelefone(String telefone) throws TamanhoException {
		super.setTelefone(telefone);
	}
	
}
