package interfaces;

import base.Funcionario;

public interface IRepositorioFuncionario {
	public void inserirFuncionario (Funcionario funcionario);
	public boolean removerFuncionario (int id);
	public void atualizarFuncionario (Funcionario funcionario);
	public Funcionario procurarFuncionario (int id);
}
