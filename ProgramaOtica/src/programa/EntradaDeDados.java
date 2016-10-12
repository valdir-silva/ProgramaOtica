package programa;

public class EntradaDeDados {
	public CadastroClientes clientes;
	public CadastroFornecedores fornecedores;
	public CadastroProdutos produtos;
	public CadastroVendas vendas;
	
	public EntradaDeDados () {
		IRepositorioCliente repositorioClientes = new RepositorioClienteArray();
		clientes = new CadastroClientes (repositorioClientes);
		
		IRepositorioFornecedor repositorioFornecedores = new RepositorioFornecedorArray();
		fornecedores = new CadastroFornecedores (repositorioFornecedores);
		
		IRepositorioProduto repositorioProdutos = new RepositorioProdutoArray();
		produtos = new CadastroProdutos (repositorioProdutos);
		
		IRepositorioVenda repositorioVendas = new RepositorioVendaArray();
		vendas = new CadastroVendas (repositorioVendas);
	}
}
