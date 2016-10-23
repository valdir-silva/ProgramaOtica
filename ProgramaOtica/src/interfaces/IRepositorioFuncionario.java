package interfaces;

import base.Funcionario;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;

public interface IRepositorioFuncionario {
	public void inserir (Funcionario funcionario) throws SemPosicaoParaInserirException;
	public void removerFuncionario (int id) throws RemocaoNaoConcluidaException;
	public void atualizar (Funcionario funcionario) throws NullPointerException;
	public Funcionario procurarFuncionario (int id) throws NullPointerException;
}
