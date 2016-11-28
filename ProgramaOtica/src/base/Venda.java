package base;

import exceptions.RepositorioException;


import exceptions.TamanhoException;

public class Venda extends Identificacao {
	private Cliente cliente;
	private Produto produto;
	
	public Venda() {
		super();
	}
	
	public int getId() {
		return super.getId();
	}
	
	public void setId(int id) {
		super.setId(id);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) throws NullPointerException, RepositorioException, TamanhoException {
		this.cliente = cliente;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
