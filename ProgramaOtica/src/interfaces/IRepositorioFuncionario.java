package interfaces;

import base.Funcionario;
import exceptions.IdNaoExisteException;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import repositorios.RepositorioFuncionarioArray;

public interface IRepositorioFuncionario {
	public void inserir (Funcionario funcionario) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException;
	public void removerFuncionario (int id) throws  RepositorioException;
	public void atualizar (Funcionario funcionario) throws NullPointerException, RepositorioException;
	public Funcionario procurarFuncionario (int id) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException;
	public RepositorioFuncionarioArray todosFuncionarios () throws TamanhoException;
}
