package base;

import exceptions.RepositorioException;


import exceptions.TamanhoException;

public class Venda extends Identificacao {
	private int IdCliente;
	private int IdProduto;
	
	public Venda() {
		super();
	}
	
	public int getId() {
		return super.getId();
	}
	
	public void setId(int id) {
		super.setId(id);
	}
	
	public int getCliente() {
		return IdCliente;
	}
	
	public void setCliente(int IdCliente) throws NullPointerException, RepositorioException, TamanhoException {
		this.IdCliente = IdCliente;
	}
	
	public int getProduto() {
		return IdProduto;
	}
	
	public void setProduto(int IdProduto) {
		this.IdProduto = IdProduto;
	}
	
}
