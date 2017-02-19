package interfaces;

import base.ItemVenda;

import exceptions.IdNaoExisteException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import repositorios.RepositorioItemVendaArray;

public interface IRepositorioItemVenda {
	public void inserir (ItemVenda venda) throws SemPosicaoParaInserirException, RepositorioException, NullPointerException, TamanhoException, QuantidadeProdutoInvalidaException;
	public void removerItemVenda (int id) throws RepositorioException;
	public void atualizar (ItemVenda venda) throws NullPointerException, RepositorioException, TamanhoException;
	public ItemVenda procurarItemVenda (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException;
	public RepositorioItemVendaArray todosItensVenda (int idVenda) throws TamanhoException;
	public void InserirIdVenda(int itemVenda, int idVenda);
}
