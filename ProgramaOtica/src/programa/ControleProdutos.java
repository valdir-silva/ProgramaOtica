package programa;

import base.Produto;
import interfaces.IRepositorioProduto;

public class ControleProdutos implements IRepositorioProduto {
	IRepositorioProduto repositorioProduto;
	Produto produto;
	
	public ControleProdutos (IRepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}
	
	public void inserirProduto (Produto produto) {
		repositorioProduto.inserirProduto(produto);
	}
	
	public boolean removerProduto (int id) {
		if (repositorioProduto.removerProduto(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void atualizarProduto (Produto produto) {
		repositorioProduto.atualizarProduto(produto);
	}
	
	public Produto procurarProduto (int id) {
		return repositorioProduto.procurarProduto(id);
	}
}
