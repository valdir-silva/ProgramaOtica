package programa;

import base.Produto;

import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioProduto;

public class ControleProdutos implements IRepositorioProduto {
	IRepositorioProduto repositorioProduto;
	Produto produto;
	
	public ControleProdutos (IRepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}
	
	public void inserir (Produto produto) throws SemPosicaoParaInserirException {
		repositorioProduto.inserir(produto);
	}
	
	public void removerProduto (int id) throws NullPointerException {
		repositorioProduto.removerProduto(id);
	}
	
	public void atualizar (Produto produto) throws NullPointerException {
		repositorioProduto.atualizar(produto);
	}
	
	public Produto procurarProduto (int id) throws NullPointerException {
		return repositorioProduto.procurarProduto(id);
	}
}
