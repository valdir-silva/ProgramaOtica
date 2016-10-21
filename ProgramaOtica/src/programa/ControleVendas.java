package programa;

import base.Venda;
import interfaces.IRepositorioVenda;

public class ControleVendas implements IRepositorioVenda {
	IRepositorioVenda repositorioVenda;
	Venda venda;
	
	public ControleVendas (IRepositorioVenda repositorioVenda) {
		this.repositorioVenda = repositorioVenda;
	}
	
	public void inserirVenda (Venda venda) {
		repositorioVenda.inserirVenda(venda);
	}
	
	public boolean removerVenda (int id) {
		if (repositorioVenda.removerVenda(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void atualizarVenda (Venda venda) {
		repositorioVenda.atualizarVenda(venda);
	}
	
	public Venda procurarVenda (int id) {
		return repositorioVenda.procurarVenda(id);
	}

}
