package repositorios;

import base.Funcionario;

import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioFuncionario;

public class RepositorioFuncionarioArray implements IRepositorioFuncionario {
	private Funcionario[] funcionario;
	private int indice;
	
	public RepositorioFuncionarioArray () {
		funcionario = new Funcionario[100];
	}
			
	public void inserir(Funcionario funcionario) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.funcionario[indice] == null){//se a posição esta vaga coloque
			this.funcionario[indice] = funcionario;
			funcionario.setId(indice);
			found = true;
			indice++;
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.funcionario.length; i++){
				if (this.funcionario[i] == null){
					this.funcionario[indice] = funcionario;
					found = true;
					indice++;
					break;
				}
			}
		}
		if (!found) {// se nao inserio
			SemPosicaoParaInserirException e = new SemPosicaoParaInserirException();
			throw e;
		}
	}

	public void removerFuncionario(int id) {
		boolean found = false;
		for (int i = 0;i < this.funcionario.length;i++){
			if (this.funcionario[i].getId() == id){
				this.funcionario[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		if (!found) {//se não removeu!!
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}

	public void atualizar(Funcionario funcionario) throws NullPointerException{
		boolean found = false;
		for (int i = 0;i < this.funcionario.length;i++){
			if (this.funcionario[i].getId() == funcionario.getId()){
				this.funcionario[i] = funcionario;
				found = true;
				break;
			}
		}
		if (!found) {
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}

	public Funcionario procurarFuncionario(int id) throws NullPointerException{
		for (int i = 0; i < this.funcionario.length; i++){
			if(this.funcionario[i].getId() == id) {
				return this.funcionario[i];
			}
		}
		NullPointerException e = new NullPointerException();
		throw e;
	}
}
