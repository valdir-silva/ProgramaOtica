package programa;

public class ControleFornecedores implements  IRepositorioFornecedor{
	IRepositorioFornecedor repositorioFornecedor;
	Fornecedor fornecedor;
	
	public ControleFornecedores (IRepositorioFornecedor repositorioFornecedor) {
		this.repositorioFornecedor = repositorioFornecedor;
	}
	
	public void inserirFornecedor (Fornecedor fornecedor) {
		repositorioFornecedor.inserirFornecedor(fornecedor);
	}
	
	public boolean removerFornecedor (int id) {
		if (repositorioFornecedor.removerFornecedor(id)) {
			return true;
		} else {
			return false;
		}	
	}
	
	public void atualizarFornecedor (Fornecedor fornecedor) {
		repositorioFornecedor.atualizarFornecedor(fornecedor);
	}
	
	public Fornecedor procurarFornecedor (int id) {
		return repositorioFornecedor.procurarFornecedor(id);
	}
}
