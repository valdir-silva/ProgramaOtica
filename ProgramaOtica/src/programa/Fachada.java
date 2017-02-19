package programa;

import base.Cliente;


import base.Funcionario;
import base.ItemVenda;
import base.Produto;
import base.Venda;
import exceptions.IdNaoExisteException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioFuncionario;
import interfaces.IRepositorioItemVenda;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioVenda;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioClienteBanco;
import repositorios.RepositorioFuncionarioArray;
import repositorios.RepositorioFuncionarioBanco;
import repositorios.RepositorioItemVendaArray;
import repositorios.RepositorioItemVendaBanco;
import repositorios.RepositorioProdutoArray;
import repositorios.RepositorioProdutoBanco;
import repositorios.RepositorioVendaArray;
import repositorios.RepositorioVendaBanco;

public class Fachada {
	private static Fachada instance;
	private ControleClientes clientes;
	private ControleFuncionarios funcionarios;
	private ControleProdutos produtos;
	private ControleVendas vendas;
	private ControleItensVenda itensVenda;

	private Fachada (String server, String user, String key) {
		RepositorioClienteBanco instanceCliente = RepositorioClienteBanco.getInstance(server, user, key);
		IRepositorioCliente repositorioCliente = instanceCliente;
		clientes = new ControleClientes (repositorioCliente);
		
		RepositorioFuncionarioBanco instanceFuncionario = RepositorioFuncionarioBanco.getInstance(server, user, key);
		IRepositorioFuncionario repositorioFuncionario = instanceFuncionario;
		funcionarios = new ControleFuncionarios (repositorioFuncionario);
		
		RepositorioProdutoBanco instanceProduto = RepositorioProdutoBanco.getInstance(server, user, key);
		IRepositorioProduto repositorioProduto = instanceProduto;
		produtos = new ControleProdutos (repositorioProduto);
		
		RepositorioVendaBanco instanceVenda = RepositorioVendaBanco.getInstance(server, user, key);
		IRepositorioVenda repositorioVenda = instanceVenda;
		vendas = new ControleVendas (repositorioVenda);
		
		RepositorioItemVendaBanco instanceItemVenda = RepositorioItemVendaBanco.getInstance(server, user, key);
		IRepositorioItemVenda repositorioItemVenda = instanceItemVenda;
		itensVenda = new ControleItensVenda(repositorioItemVenda);
		
	}
	
	// Singleton method 
	public synchronized static Fachada getInstance (String server, String user, String key) {
		if (instance == null) {
			instance = new Fachada(server,user,key);
		}
		return instance;
	}
	
	/////////////
	///Cliente///
	/////////////
	
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException {
		this.clientes.inserir(cliente);
	}
	
	public void atualizar (Cliente cliente) throws NullPointerException, RepositorioException {
		this.clientes.atualizar(cliente);
	}
	
	public Cliente procurarCliente (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException {
		return this.clientes.procurarCliente(id);
	}
	
	public void removerCliente (int id) throws RepositorioException {
		this.clientes.removerCliente(id);
	}
	
	public RepositorioClienteArray todosClientes() throws TamanhoException {
		return this.clientes.todosClientes();
	}

	////////////////
	///Funcionario//
	////////////////

	public void inserir (Funcionario funcionario) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException {
		this.funcionarios.inserir(funcionario);
	}
	
	public void atualizar (Funcionario funcionario) throws NullPointerException, RepositorioException {
		this.funcionarios.atualizar(funcionario);
	}
	
	public Funcionario procurarFuncionario (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException {
		return this.funcionarios.procurarFuncionario(id);
	}
	
	public void removerFuncionario (int id) throws RepositorioException {
		this.funcionarios.removerFuncionario(id);
	}
	
	public RepositorioFuncionarioArray todosFuncionarios() throws TamanhoException {
		return this.funcionarios.todosFuncionarios();
	}
	
	/////////////
	///Produto///
	/////////////
	
	public void inserir (Produto produto) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException {
		this.produtos.inserir(produto);
	}
	
	public void atualizar (Produto produto) throws NullPointerException, RepositorioException {
		this.produtos.atualizar(produto);
	}
	
	public Produto procurarProduto (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException {
		return this.produtos.procurarProduto(id);
	}
	
	public void removerProduto (int id) throws RepositorioException {
		this.produtos.removerProduto(id);
	}
	
	public RepositorioProdutoArray todosProdutos() throws TamanhoException {
		return this.produtos.todosProdutos();
	}
	
	/////////////
	////Venda////
	/////////////

	public void inserir (Venda produto) throws SemPosicaoParaInserirException, RepositorioException, NullPointerException, TamanhoException, QuantidadeProdutoInvalidaException {
		this.vendas.inserir(produto);
	}
	
	public void atualizar (Venda produto) throws NullPointerException, RepositorioException, TamanhoException {
		this.vendas.atualizar(produto);
	}
	
	public Venda procurarVenda (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException {
		return this.vendas.procurarVenda(id);
	}
	
	public void removerVenda (int id) throws RepositorioException {
		this.vendas.removerVenda(id);
	}
	
	public RepositorioVendaArray todasVendas() throws TamanhoException {
		return this.vendas.todasVendas();
		}
	
	//////////////////
	////Item Venda////
	//////////////////
	
	public void inserir (ItemVenda produto) throws SemPosicaoParaInserirException, RepositorioException, NullPointerException, TamanhoException, QuantidadeProdutoInvalidaException {
		this.itensVenda.inserir(produto);
	}
	
	public void atualizar (ItemVenda produto) throws NullPointerException, RepositorioException, TamanhoException {
		this.itensVenda.atualizar(produto);
	}
	
	public ItemVenda procurarItemVenda (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException {
		return this.itensVenda.procurarItemVenda(id);
	}
	
	public void removerItemVenda (int id) throws RepositorioException {
		this.itensVenda.removerItemVenda(id);
	}
	
	public RepositorioItemVendaArray todosItensVenda(int idVenda) throws TamanhoException {
		return this.itensVenda.todosItensVenda(idVenda);
	}
	
	public void InserirIdVenda(int itemVenda, int idVenda) {
		this.itensVenda.InserirIdVenda(itemVenda, idVenda);
	}
}
