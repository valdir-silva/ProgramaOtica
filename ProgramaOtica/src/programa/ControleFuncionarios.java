package programa;

import base.Funcionario;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioFuncionario;

public class ControleFuncionarios implements  IRepositorioFuncionario{
	IRepositorioFuncionario repositorioFuncionario;
	Funcionario funcionario;
	
	public ControleFuncionarios (IRepositorioFuncionario repositorioFuncionario) {
		this.repositorioFuncionario = repositorioFuncionario;
	}
	
	public void inserir(Funcionario funcionario) throws SemPosicaoParaInserirException, RepositorioException {
		repositorioFuncionario.inserir(funcionario);
	}

	public void removerFuncionario(int id) throws RemocaoNaoConcluidaException, RepositorioException {
		repositorioFuncionario.removerFuncionario(id);
	}

	public void atualizar(Funcionario funcionario) throws NullPointerException, RepositorioException {
		repositorioFuncionario.atualizar(funcionario);
	}

	public Funcionario procurarFuncionario(int id) throws NullPointerException, RepositorioException, TamanhoException {
		return repositorioFuncionario.procurarFuncionario(id);
	}
}
