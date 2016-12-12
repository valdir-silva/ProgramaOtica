package interfaces;

import base.Produto;

import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import repositorios.RepositorioProdutoArray;

public interface IRepositorioProduto {
	public void inserir (Produto produto) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException;
	public void removerProduto (int id) throws RepositorioException;
	public void atualizar (Produto produto) throws NullPointerException, RepositorioException;
	public Produto procurarProduto (int id) throws NullPointerException, RepositorioException, TamanhoException;
	public RepositorioProdutoArray todosProdutos () throws TamanhoException;
}
