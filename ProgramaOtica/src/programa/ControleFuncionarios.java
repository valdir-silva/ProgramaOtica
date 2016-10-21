package programa;

import base.Funcionario;
import interfaces.IRepositorioFuncionario;

public class ControleFuncionarios implements  IRepositorioFuncionario{
	IRepositorioFuncionario repositorioFuncionario;
	Funcionario funcionario;
	
	public ControleFuncionarios (IRepositorioFuncionario repositorioFuncionario) {
		this.repositorioFuncionario = repositorioFuncionario;
	}
	
	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		repositorioFuncionario.inserirFuncionario(funcionario);
	}

	@Override
	public boolean removerFuncionario(int id) {
		if (repositorioFuncionario.removerFuncionario(id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void atualizarFuncionario(Funcionario funcionario) {
		repositorioFuncionario.atualizarFuncionario(funcionario);
	}

	@Override
	public Funcionario procurarFuncionario(int id) {
		return repositorioFuncionario.procurarFuncionario(id);
	}
}
