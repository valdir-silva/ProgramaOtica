package interfaces;

import base.Cliente;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public interface IRepositorioCliente {
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException, RepositorioException;
	public void removerCliente (int id) throws RemocaoNaoConcluidaException, RepositorioException;
	public void atualizar (Cliente cliente) throws NullPointerException, RepositorioException;
	public Cliente procurarCliente (int id) throws NullPointerException, RepositorioException, TamanhoException;
}
