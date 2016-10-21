package programa;

public class EntradaDeDados {
	public ControleClientes clientes;
	public ControleFuncionarios fornecedores;
	public ControleProdutos produtos;
	public ControleVendas vendas;
	
	public EntradaDeDados () {
		IRepositorioCliente repositorioClientes = new RepositorioClienteArray();
		clientes = new ControleClientes (repositorioClientes);
		
		IRepositorioFuncionario repositorioFornecedores = new RepositorioFuncionario();
		fornecedores = new ControleFuncionarios (repositorioFornecedores);
		
		IRepositorioProduto repositorioProdutos = new RepositorioProdutoArray();
		produtos = new ControleProdutos (repositorioProdutos);
		
		IRepositorioVenda repositorioVendas = new RepositorioVendaArray();
		vendas = new ControleVendas (repositorioVendas);
	}
}
