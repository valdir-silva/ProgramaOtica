package programa;

public class CadastroVendas implements IRepositorioVenda {
	IRepositorioVenda repositorioVenda;
	Venda venda;
	
	public CadastroVendas (IRepositorioVenda repositorioVenda) {
		this.repositorioVenda = repositorioVenda;
	}
	
	public void inserirVenda (Venda venda) {
		repositorioVenda.inserirVenda(venda);
	}
	
	public void removerVenda (int id) {
		repositorioVenda.removerVenda(id);
	}
	
	public void atualizarVenda (Venda venda) {
		repositorioVenda.atualizarVenda(venda);
	}
	
	public Venda procurarVenda (int id) {
		return repositorioVenda.procurarVenda(id);
	}

}
