package programa;

public class CadastroFornecedores implements  IRepositorioFornecedor{
	IRepositorioFornecedor repositorioFornecedor;
	Fornecedor fornecedor;
	
	public CadastroFornecedores (IRepositorioFornecedor repositorioFornecedor) {
		this.repositorioFornecedor = repositorioFornecedor;
	}
	
	public void inserirFornecedor (Fornecedor fornecedor) {
		repositorioFornecedor.inserirFornecedor(fornecedor);
	}
	
	public void removerFornecedor (int id) {
		repositorioFornecedor.removerFornecedor(id);
	}
	
	public void atualizarFornecedor (Fornecedor fornecedor) {
		repositorioFornecedor.atualizarFornecedor(fornecedor);
	}
	
	public Fornecedor procurarFornecedor (int id) {
		return repositorioFornecedor.procurarFornecedor(id);
	}
}
