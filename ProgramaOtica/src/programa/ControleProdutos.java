package programa;

import base.Produto;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioProduto;

public class ControleProdutos implements IRepositorioProduto {
	IRepositorioProduto repositorioProduto;
	Produto produto;
	
	public ControleProdutos (IRepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}
	
	public void inserir (Produto produto) throws SemPosicaoParaInserirException, RepositorioException {
		repositorioProduto.inserir(produto);
	}
	
	public void removerProduto (int id) throws RemocaoNaoConcluidaException, RepositorioException {
		repositorioProduto.removerProduto(id);
	}
	
	public void atualizar (Produto produto) throws NullPointerException, RepositorioException {
		repositorioProduto.atualizar(produto);
	}
	
	public Produto procurarProduto (int id) throws NullPointerException, RepositorioException, TamanhoException {
		return repositorioProduto.procurarProduto(id);
	}
}
