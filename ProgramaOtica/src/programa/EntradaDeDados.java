package programa;

public class EntradaDeDados {
	public ControleClientes clientes;
	public ControleFornecedores fornecedores;
	public ControleProdutos produtos;
	public ControleVendas vendas;
	
	public EntradaDeDados () {
		IRepositorioCliente repositorioClientes = new RepositorioClienteArray();
		clientes = new ControleClientes (repositorioClientes);
		
		IRepositorioFornecedor repositorioFornecedores = new RepositorioFornecedorArray();
		fornecedores = new ControleFornecedores (repositorioFornecedores);
		
		IRepositorioProduto repositorioProdutos = new RepositorioProdutoArray();
		produtos = new ControleProdutos (repositorioProdutos);
		
		IRepositorioVenda repositorioVendas = new RepositorioVendaArray();
		vendas = new ControleVendas (repositorioVendas);
	}
}
