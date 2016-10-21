package repositorios;

import base.Venda;
import interfaces.IRepositorioVenda;

public class RepositorioVendaArray implements IRepositorioVenda{
	private Venda[] venda;
	private int indice;
	
	public RepositorioVendaArray () {
		this.venda = new Venda[100];
	}
	
	public void inserirVenda (Venda venda) {
		if (this.venda[indice] == null){//se a posição esta vaga coloque
			this.venda[indice] = venda;
			venda.setId(indice);
			indice++;			
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.venda.length; i++){
				if (this.venda[i] == null){
					this.venda[indice] = venda;
					indice++;
					break;
				}
			}
		}
	}
	
	public boolean removerVenda (int id) {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == id) {
				this.venda[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		/*
		if (found) {
			System.out.println("Venda removido com sucesso!!");
		}else {//throw VendaNotFound;
			System.out.println("Venda nao encontrado!!");
		}*/
		return found;
	}
	
	public void atualizarVenda (Venda venda) {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == venda.getId()) {
				this.venda[i] = venda;
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Venda removido com sucesso!!");
		}else {//throw VendaNotFound;
			System.out.println("Venda nao encontrado!!");
		}
	}
	
	public Venda procurarVenda (int id) {
		for (int i = 0; i < this.venda.length; i++){
			if(this.venda[i].getId() == id) {
				return this.venda[i];
			}
		}
		return null;//null se n existir essa venda
	}
	
}
