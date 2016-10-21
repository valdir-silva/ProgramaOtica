package repositorios;

import base.Cliente;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioCliente;

public class RepositorioClienteArray implements IRepositorioCliente {
	private Cliente[] cliente;
	private int indice;
	
	public RepositorioClienteArray () {
		cliente = new Cliente[100];
	}
	
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.cliente[indice] == null){//se a posição esta vaga coloque
			this.cliente[indice] = cliente;
			cliente.setId(indice);//gerar id com o indice do vetor
			found = true;
			indice++;
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.cliente.length; i++){
				if (this.cliente[i] == null){
					this.cliente[indice] = cliente;
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
	
	public void removerCliente (int id) throws RemocaoNaoConcluidaException{
		boolean found = false;
		for (int i = 0; i < this.cliente.length; i++){
			if (this.cliente[i].getId() == id) {
				this.cliente[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		if (!found) {//se não removeu!!
			RemocaoNaoConcluidaException e = new RemocaoNaoConcluidaException();
			throw e;
		}
	}
	
	public void atualizar (Cliente cliente) throws NullPointerException {
		boolean found = false;
		for (int i = 0; i < this.cliente.length; i++){
			if (this.cliente[i].getId() == cliente.getId()) {
				this.cliente[i] = cliente;
				found = true;
				break;
			}
		}
		if (!found) {
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public Cliente procurarCliente (int id) throws NullPointerException {
		for (int i = 0; i < this.cliente.length; i++){
			if(this.cliente[i].getId() == id) {
				return this.cliente[i];
			}
		}
		NullPointerException e = new NullPointerException();
		throw e;
	}
}
