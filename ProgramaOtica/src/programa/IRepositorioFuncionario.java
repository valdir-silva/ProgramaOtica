package programa;

public interface IRepositorioFornecedor {
	public void inserirFornecedor (Fornecedor fornecedor);
	public boolean removerFornecedor (int id);
	public void atualizarFornecedor (Fornecedor fornecedor);
	public Fornecedor procurarFornecedor (int id);
}
