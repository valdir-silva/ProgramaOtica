package interfaces;

import base.Produto;

import exceptions.SemPosicaoParaInserirException;

public interface IRepositorioProduto {
	public void inserir (Produto produto) throws SemPosicaoParaInserirException;
	public void removerProduto (int id) throws NullPointerException;
	public void atualizar (Produto produto) throws NullPointerException;
	public Produto procurarProduto (int id) throws NullPointerException;
}
