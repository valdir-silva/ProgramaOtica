package programa;

import base.ItemVenda;

import exceptions.IdNaoExisteException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioItemVenda;
import repositorios.RepositorioItemVendaArray;

public class ControleItensVenda implements IRepositorioItemVenda {
	IRepositorioItemVenda vendas;
	
	public ControleItensVenda (IRepositorioItemVenda repositorioVenda) {
		this.vendas = repositorioVenda;
	}
	
	public void inserir (ItemVenda venda) throws SemPosicaoParaInserirException, RepositorioException, NullPointerException, TamanhoException, QuantidadeProdutoInvalidaException {
		this.vendas.inserir(venda);
	}
	
	public void removerItemVenda (int id) throws RepositorioException {
		this.vendas.removerItemVenda(id);
	}
	
	public void atualizar (ItemVenda venda) throws NullPointerException, RepositorioException, TamanhoException {
		this.vendas.atualizar(venda);
	}
	
	public ItemVenda procurarItemVenda (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException {
		return this.vendas.procurarItemVenda(id);
	}
	
	public RepositorioItemVendaArray todosItensVenda () throws TamanhoException {
		return this.vendas.todosItensVenda();
	}

	@Override
	public void InserirIdVenda(int itemVenda, int idVenda) {
		this.vendas.InserirIdVenda(itemVenda, idVenda);
	}

}
