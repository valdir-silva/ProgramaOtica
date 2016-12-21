package repositorios;

import base.Cliente;

import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public class RepositorioClienteArray {
	private Cliente[] cliente;
	private int indice;
	
	public RepositorioClienteArray () {
		cliente = new Cliente[100];
	}
	
	public void inserir (Cliente cliente) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.cliente[indice] == null){//se a posição esta vaga coloque
			this.cliente[indice] = cliente;
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
	
	public void removerCliente (int id) {
//		boolean found = false;
		for (int i = 0; i < this.cliente.length; i++){
			if (this.cliente[i].getId() == id) {
				this.cliente[i] = null;
				indice--;
//				found = true;
				break;
			}
		}
//		if (!found) {//se não removeu!!
//			RemocaoNaoConcluidaException e = new RemocaoNaoConcluidaException();
//			throw e;
//		}
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
	
	public String[][] todosClientes() throws TamanhoException {
		int i = 0;
		String[][] clientes = new String [cliente.length][9];
		
		while (cliente[i] != null){
			
			clientes[i][0] = Integer.toString(cliente[i].getId());
			clientes[i][1] = cliente[i].getNome();
			clientes[i][2] = cliente[i].getNascimento();
			clientes[i][3] = cliente[i].getCpf();
			clientes[i][4] = cliente[i].getTelefone();
			clientes[i][5] = cliente[i].getEndereco().getCep();
			clientes[i][6] = cliente[i].getEndereco().getEstado();
			clientes[i][7] = cliente[i].getEndereco().getCidade();
			clientes[i][8] = cliente[i].getEndereco().getRua();
			
			i++;
		}
		return clientes;
	}

	
	
}
