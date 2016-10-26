package interfaces;

import base.Funcionario;

import exceptions.SemPosicaoParaInserirException;

public interface IRepositorioFuncionario {
	public void inserir (Funcionario funcionario) throws SemPosicaoParaInserirException;
	public void removerFuncionario (int id) throws NullPointerException;
	public void atualizar (Funcionario funcionario) throws NullPointerException;
	public Funcionario procurarFuncionario (int id) throws NullPointerException;
}
