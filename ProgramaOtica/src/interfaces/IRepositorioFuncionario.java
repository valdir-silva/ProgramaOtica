package interfaces;

import base.Funcionario;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public interface IRepositorioFuncionario {
	public void inserir (Funcionario funcionario) throws SemPosicaoParaInserirException, RepositorioException;
	public void removerFuncionario (int id) throws RemocaoNaoConcluidaException, RepositorioException;
	public void atualizar (Funcionario funcionario) throws NullPointerException, RepositorioException;
	public Funcionario procurarFuncionario (int id) throws NullPointerException, RepositorioException, TamanhoException;
}
