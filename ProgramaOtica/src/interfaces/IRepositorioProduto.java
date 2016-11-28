package interfaces;

import base.Produto;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public interface IRepositorioProduto {
	public void inserir (Produto produto) throws SemPosicaoParaInserirException, RepositorioException;
	public void removerProduto (int id) throws RemocaoNaoConcluidaException, RepositorioException;
	public void atualizar (Produto produto) throws NullPointerException, RepositorioException;
	public Produto procurarProduto (int id) throws NullPointerException, RepositorioException, TamanhoException;
}
