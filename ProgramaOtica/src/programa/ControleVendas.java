package programa;

import base.Venda;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioVenda;

public class ControleVendas implements IRepositorioVenda {
	IRepositorioVenda repositorioVenda;
	Venda venda;
	
	public ControleVendas (IRepositorioVenda repositorioVenda) {
		this.repositorioVenda = repositorioVenda;
	}
	
	public void inserir (Venda venda) throws SemPosicaoParaInserirException, RepositorioException {
		repositorioVenda.inserir(venda);
	}
	
	public void removerVenda (int id) throws RemocaoNaoConcluidaException, RepositorioException {
		repositorioVenda.removerVenda(id);
	}
	
	public void atualizar (Venda venda) throws NullPointerException, RepositorioException {
		repositorioVenda.atualizar(venda);
	}
	
	public Venda procurarVenda (int id) throws NullPointerException, RepositorioException, TamanhoException {
		return repositorioVenda.procurarVenda(id);
	}

}
