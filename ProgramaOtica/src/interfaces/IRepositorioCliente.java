package interfaces;

import base.Cliente;

import exceptions.SemPosicaoParaInserirException;

public interface IRepositorioCliente {
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException;
	public void removerCliente (int id) throws NullPointerException;
	public void atualizar (Cliente cliente) throws NullPointerException;
	public Cliente procurarCliente (int id) throws NullPointerException;
}
