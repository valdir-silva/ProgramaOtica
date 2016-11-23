package programa;

import base.Cliente;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioCliente;

public class ControleClientes {
	private IRepositorioCliente clientes;
	
	public ControleClientes (IRepositorioCliente clientes) {
		this.clientes = clientes;
	}
	
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
	
	
}
