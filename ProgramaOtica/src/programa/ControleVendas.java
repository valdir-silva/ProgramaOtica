package programa;

import base.Venda;
import exceptions.IdNaoExisteException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioVenda;
import repositorios.RepositorioVendaArray;

public class ControleVendas implements IRepositorioVenda {
	IRepositorioVenda vendas;
	
	public ControleVendas (IRepositorioVenda repositorioVenda) {
		this.vendas = repositorioVenda;
	}
	
	public void inserir (Venda venda) throws SemPosicaoParaInserirException, RepositorioException, NullPointerException, TamanhoException, QuantidadeProdutoInvalidaException {
		this.vendas.inserir(venda);
	}
	
	public void removerVenda (int id) throws RepositorioException {
		this.vendas.removerVenda(id);
	}
	
	public void atualizar (Venda venda) throws NullPointerException, RepositorioException, TamanhoException {
		this.vendas.atualizar(venda);
	}
	
	public Venda procurarVenda (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException {
		return this.vendas.procurarVenda(id);
	}
	
	public RepositorioVendaArray todasVendas() throws TamanhoException {
		return this.vendas.todasVendas();
	}

}
