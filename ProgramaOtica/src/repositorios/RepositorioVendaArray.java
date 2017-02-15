package repositorios;

import base.Venda;


import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public class RepositorioVendaArray {
	private Venda[] venda;
	private int indice;
	
	public RepositorioVendaArray () {
		this.venda = new Venda[100];
	}
	
	public void inserir (Venda venda) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.venda[indice] == null){//se a posição esta vaga coloque
			this.venda[indice] = venda;
			found = true;
			indice++;			
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.venda.length; i++){
				if (this.venda[i] == null){
					this.venda[indice] = venda;
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
	
	public void removerVenda (int id) {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == id) {
				this.venda[i] = null;
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
	
	public void atualizar (Venda venda) throws NullPointerException {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == venda.getId()) {
				this.venda[i] = venda;
				found = true;
				break;
			}
		}
		if (!found) {
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public Venda procurarVenda (int id) throws NullPointerException {
		for (int i = 0; i < this.venda.length; i++){
			if(this.venda[i].getId() == id) {
				return this.venda[i];
			}
		}
		NullPointerException e = new NullPointerException();
		throw e;
	}
	
	public String[][] todasVendas() throws TamanhoException {
		int i = 0;
		String[][] vendas = new String [venda.length][9];
		
		while (venda[i] != null){
			
			vendas[i][0] = Integer.toString(venda[i].getId());
			vendas[i][1] = Integer.toString(venda[i].getCliente());
			vendas[i][2] = Integer.toString(venda[i].getProduto());
			
			i++;
		}
		return vendas;
	}	
}
