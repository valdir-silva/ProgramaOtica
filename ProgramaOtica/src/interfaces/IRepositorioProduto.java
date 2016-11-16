package interfaces;

import base.Produto;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;

public interface IRepositorioProduto {
	public void inserir (Produto produto) throws SemPosicaoParaInserirException;
	public void removerProduto (int id) throws RemocaoNaoConcluidaException;
	public void atualizar (Produto produto) throws NullPointerException;
	public Produto procurarProduto (int id) throws NullPointerException;
}
