package programa;

import base.Venda;

import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioVenda;

public class ControleVendas implements IRepositorioVenda {
	IRepositorioVenda repositorioVenda;
	Venda venda;
	
	public ControleVendas (IRepositorioVenda repositorioVenda) {
		this.repositorioVenda = repositorioVenda;
	}
	
	public void inserir (Venda venda) throws SemPosicaoParaInserirException {
		repositorioVenda.inserir(venda);
	}
	
	public void removerVenda (int id) throws NullPointerException {
		repositorioVenda.removerVenda(id);
	}
	
	public void atualizar (Venda venda) throws NullPointerException {
		repositorioVenda.atualizar(venda);
	}
	
	public Venda procurarVenda (int id) throws NullPointerException {
		return repositorioVenda.procurarVenda(id);
	}

}
