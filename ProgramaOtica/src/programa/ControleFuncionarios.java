package programa;

import base.Funcionario;

import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioFuncionario;
import repositorios.RepositorioFuncionarioArray;

public class ControleFuncionarios implements IRepositorioFuncionario{
	private IRepositorioFuncionario funcionarios;
	
	public ControleFuncionarios (IRepositorioFuncionario funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void inserir(Funcionario funcionario) throws SemPosicaoParaInserirException, RepositorioException, RepositorioJaExisteException {
		this.funcionarios.inserir(funcionario);
	}

	public void atualizar(Funcionario funcionario) throws NullPointerException, RepositorioException {
		this.funcionarios.atualizar(funcionario);
	}

	public Funcionario procurarFuncionario(int id) throws NullPointerException, RepositorioException, TamanhoException {
		return this.funcionarios.procurarFuncionario(id);
	}

	public void removerFuncionario(int id) throws RepositorioException {
		this.funcionarios.removerFuncionario(id);
	}

	public RepositorioFuncionarioArray todosFuncionarios() throws TamanhoException {
		return this.funcionarios.todosFuncionarios();
	}
}
