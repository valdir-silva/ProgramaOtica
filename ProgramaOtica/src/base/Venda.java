package base;

import interfaces.IRepositorioCliente;
import interfaces.IRepositorioProduto;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioProdutoArray;

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
	
	public void setCliente(int id) throws NullPointerException {
		IRepositorioCliente cliente = new RepositorioClienteArray();
		this.cliente = cliente.procurarCliente(id);
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(int id) {
		IRepositorioProduto produto = new RepositorioProdutoArray();
		this.produto = produto.procurarProduto(id);
	}
	
}
