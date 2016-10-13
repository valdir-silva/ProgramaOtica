package repositorios;

import programa.Fornecedor;

public interface IRepositorioFornecedor {
	public void inserirFornecedor (Fornecedor fornecedor);
	public void removerFornecedor (int id);
	public void atualizarFornecedor (Fornecedor fornecedor);
	public Fornecedor procurarFornecedor (int id);
}
