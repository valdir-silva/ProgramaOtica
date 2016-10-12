package programa;

public class CadastroProdutos implements IRepositorioProduto {
	IRepositorioProduto repositorioProduto;
	Produto produto;
	
	public CadastroProdutos (IRepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}
	
	public void inserirProduto (Produto produto) {
		repositorioProduto.inserirProduto(produto);
	}
	
	public void removerProduto (int id) {
		repositorioProduto.removerProduto(id);
	}
	
	public void atualizarProduto (Produto produto) {
		repositorioProduto.atualizarProduto(produto);
	}
	
	public Produto procurarProduto (int id) {
		return repositorioProduto.procurarProduto(id);
	}
}
