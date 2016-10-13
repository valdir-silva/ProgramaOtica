package repositorios;

import programa.Venda;

public class RepositorioVenda {
	private Venda[] venda;
	private int indice;
	
	public RepositorioVenda () {
		this.venda = new Venda[100];
	}
	
	public void inserirVenda (Venda venda) {
		this.venda[indice] = venda;
		indice++;
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
		if (found) {
			System.out.println("Venda removido com sucesso!!");
		}else {//throw VendaNotFound;
			System.out.println("Venda nao encontrado!!");
		}
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
