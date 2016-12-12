package programa;

import base.Produto;

import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioProduto;
import repositorios.RepositorioProdutoArray;

public class ControleProdutos implements IRepositorioProduto {
	IRepositorioProduto produtos;
	
	public ControleProdutos (IRepositorioProduto repositorioProduto) {
		this.produtos = repositorioProduto;
	}
	
	public void inserir (Produto produto) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException {
		this.produtos.inserir(produto);
	}
	
	public void removerProduto (int id) throws RepositorioException {
		this.produtos.removerProduto(id);
	}
	
	public void atualizar (Produto produto) throws NullPointerException, RepositorioException {
		this.produtos.atualizar(produto);
	}
	
	public Produto procurarProduto (int id) throws NullPointerException, RepositorioException, TamanhoException {
		return this.produtos.procurarProduto(id);
	}

	public RepositorioProdutoArray todosProdutos() throws TamanhoException {
		return this.produtos.todosProdutos();
	}
}
