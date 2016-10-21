package programa;

import base.Cliente;
import base.Funcionario;
import base.Produto;
import base.Venda;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioFuncionario;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioVenda;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioFuncionario;
import repositorios.RepositorioProdutoArray;
import repositorios.RepositorioVendaArray;

public class Fachada {
	private static Fachada instance = null;
	private ControleClientes clientes;
	private ControleFuncionarios fornecedores;
	private ControleProdutos produtos;
	private ControleVendas vendas;
	
	public Fachada () {
		IRepositorioCliente repositorioClientes = new RepositorioClienteArray();
		clientes = new ControleClientes (repositorioClientes);
		
		IRepositorioFuncionario repositorioFornecedores = new RepositorioFuncionario();
		fornecedores = new ControleFuncionarios (repositorioFornecedores);
		
		IRepositorioProduto repositorioProdutos = new RepositorioProdutoArray();
		produtos = new ControleProdutos (repositorioProdutos);
		
		IRepositorioVenda repositorioVendas = new RepositorioVendaArray();
		vendas = new ControleVendas (repositorioVendas);
	}
	
	// Singleton method 
	public static Fachada getInstance () {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	/////////////
	///Cliente///
	/////////////
	
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException {
		this.clientes.inserir(cliente);
	}
	
	public void atualizar (Cliente cliente) throws NullPointerException {
		this.clientes.atualizar(cliente);
	}
	
	public Cliente procurarCliente (int id) throws NullPointerException {
		return this.clientes.procurarCliente(id);
	}
	
	public void removerCliente (int id) throws RemocaoNaoConcluidaException {
		this.clientes.removerCliente(id);
	}

	////////////////
	///Funcionario//
	////////////////

	public void inserirFuncionario (Funcionario funcionario) {
		this.fornecedores.inserirFuncionario(funcionario);
	}
	
	public void atualizarFuncionario (Funcionario funcionario) {
		this.fornecedores.atualizarFuncionario(funcionario);
	}
	
	public Funcionario procurarFuncionario (int id) {
		return this.fornecedores.procurarFuncionario(id);
	}
	
	public void removerFuncionario (int id) {
		this.fornecedores.removerFuncionario(id);
	}
	
	/////////////
	///Produto///
	/////////////
	
	public void inserirProduto (Produto produto) {
		this.produtos.inserirProduto(produto);
	}
	
	public void atualizarProduto (Produto produto) {
		this.produtos.atualizarProduto(produto);
	}
	
	public Produto procurarProduto (int id) {
		return this.produtos.procurarProduto(id);
	}
	
	public void removerProduto (int id) {
		this.produtos.removerProduto(id);
	}
	
	/////////////
	////Venda////
	/////////////

	public void inserirVenda (Venda produto) {
		this.vendas.inserirVenda(produto);
	}
	
	public void atualizarVenda (Venda produto) {
		this.vendas.atualizarVenda(produto);
	}
	
	public Venda procurarVenda (int id) {
		return this.vendas.procurarVenda(id);
	}
	
	public void removerVenda (int id) {
		this.vendas.removerVenda(id);
	}
	
}
