package interfaces;

import base.Cliente;

import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import repositorios.RepositorioClienteArray;

public interface IRepositorioCliente {
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException;
	public void removerCliente (int id) throws RepositorioException;
	public void atualizar (Cliente cliente) throws NullPointerException, RepositorioException;
	public Cliente procurarCliente (int id) throws NullPointerException, RepositorioException, TamanhoException;
	public RepositorioClienteArray todosClientes () throws TamanhoException;
}
