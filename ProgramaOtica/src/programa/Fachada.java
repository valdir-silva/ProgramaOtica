package programa;

import base.Cliente;

import base.Funcionario;
import base.Produto;
import base.Venda;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioCliente;
import interfaces.IRepositorioFuncionario;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioVenda;
import repositorios.RepositorioClienteBanco;
import repositorios.RepositorioFuncionarioArray;
import repositorios.RepositorioProdutoArray;
import repositorios.RepositorioVendaArray;

public class Fachada {
	private static Fachada instance;
	private ControleClientes clientes;
	private ControleFuncionarios fornecedores;
	private ControleProdutos produtos;
	private ControleVendas vendas;
	
	private Fachada () {
		RepositorioClienteBanco instance = RepositorioClienteBanco.getInstance();
		IRepositorioCliente repositorioClientes = instance;
		clientes = new ControleClientes (repositorioClientes);
		
		IRepositorioFuncionario repositorioFornecedores = new RepositorioFuncionarioArray();
		fornecedores = new ControleFuncionarios (repositorioFornecedores);
		
		IRepositorioProduto repositorioProdutos = new RepositorioProdutoArray();
		produtos = new ControleProdutos (repositorioProdutos);
		
		IRepositorioVenda repositorioVendas = new RepositorioVendaArray();
		vendas = new ControleVendas (repositorioVendas);
	}
	
	// Singleton method 
	public synchronized static Fachada getInstance () {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	/////////////
	///Cliente///
	/////////////
	
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException, RepositorioException {
		this.clientes.inserir(cliente);
	}
	
	public void atualizar (Cliente cliente) throws NullPointerException, RepositorioException {
		this.clientes.atualizar(cliente);
	}
	
	public Cliente procurarCliente (int id) throws NullPointerException, RepositorioException, TamanhoException {
		return this.clientes.procurarCliente(id);
	}
	
	public void removerCliente (int id) throws RemocaoNaoConcluidaException, RepositorioException {
		this.clientes.removerCliente(id);
	}

	////////////////
	///Funcionario//
	////////////////

	public void inserir (Funcionario funcionario) throws SemPosicaoParaInserirException, RepositorioException {
		this.fornecedores.inserir(funcionario);
	}
	
	public void atualizar (Funcionario funcionario) throws NullPointerException, RepositorioException {
		this.fornecedores.atualizar(funcionario);
	}
	
	public Funcionario procurarFuncionario (int id) throws NullPointerException, RepositorioException, TamanhoException {
		return this.fornecedores.procurarFuncionario(id);
	}
	
	public void removerFuncionario (int id) throws RemocaoNaoConcluidaException, RepositorioException {
		this.fornecedores.removerFuncionario(id);
	}
	
	/////////////
	///Produto///
	/////////////
	
	public void inserir (Produto produto) throws SemPosicaoParaInserirException, RepositorioException {
		this.produtos.inserir(produto);
	}
	
	public void atualizar (Produto produto) throws NullPointerException, RepositorioException {
		this.produtos.atualizar(produto);
	}
	
	public Produto procurarProduto (int id) throws NullPointerException, RepositorioException, TamanhoException {
		return this.produtos.procurarProduto(id);
	}
	
	public void removerProduto (int id) throws RemocaoNaoConcluidaException, RepositorioException {
		this.produtos.removerProduto(id);
	}
	
	/////////////
	////Venda////
	/////////////

	public void inserir (Venda produto) throws SemPosicaoParaInserirException, RepositorioException {
		this.vendas.inserir(produto);
	}
	
	public void atualizar (Venda produto) throws NullPointerException, RepositorioException {
		this.vendas.atualizar(produto);
	}
	
	public Venda procurarVenda (int id) throws NullPointerException, RepositorioException, TamanhoException {
		return this.vendas.procurarVenda(id);
	}
	
	public void removerVenda (int id) throws RemocaoNaoConcluidaException, RepositorioException {
		this.vendas.removerVenda(id);
	}
	
}
