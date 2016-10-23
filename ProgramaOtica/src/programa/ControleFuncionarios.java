package programa;

import base.Funcionario;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioFuncionario;

public class ControleFuncionarios implements  IRepositorioFuncionario{
	IRepositorioFuncionario repositorioFuncionario;
	Funcionario funcionario;
	
	public ControleFuncionarios (IRepositorioFuncionario repositorioFuncionario) {
		this.repositorioFuncionario = repositorioFuncionario;
	}
	
	public void inserir(Funcionario funcionario) throws SemPosicaoParaInserirException {
		repositorioFuncionario.inserir(funcionario);
	}

	public void removerFuncionario(int id) throws RemocaoNaoConcluidaException {
		repositorioFuncionario.removerFuncionario(id);
	}

	public void atualizar(Funcionario funcionario) {
		repositorioFuncionario.atualizar(funcionario);
	}

	public Funcionario procurarFuncionario(int id) {
		return repositorioFuncionario.procurarFuncionario(id);
	}
}
