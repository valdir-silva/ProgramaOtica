package programa;

import base.Cliente;

import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioCliente;

public class ControleClientes {
	private IRepositorioCliente clientes;
	
	public ControleClientes (IRepositorioCliente clientes) {
		this.clientes = clientes;
	}
	
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException {
		this.clientes.inserir(cliente);
	}
	
	public void atualizar (Cliente cliente) throws NullPointerException {
		this.clientes.atualizar(cliente);
	}
	
	public Cliente procurarCliente (int id) throws NullPointerException {
		return this.clientes.procurarCliente(id);
	}
	
	public void removerCliente (int id) throws NullPointerException {
		this.clientes.removerCliente(id);
	}
	
	
}
