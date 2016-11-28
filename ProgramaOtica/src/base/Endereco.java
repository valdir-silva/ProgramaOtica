package base;

import exceptions.TamanhoException;

public class Endereco {
	private String estado;
	private String cidade;
	private String rua;
	private String cep;
	
	public Endereco() {
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) throws TamanhoException {
		if (cep.length() <= 10){
			this.cep = cep;
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
		
	}
}
